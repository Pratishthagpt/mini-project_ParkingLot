package org.example.Service;

import org.example.Exceptions.GateNotFoundException;
import org.example.Exceptions.ParkingSlotNotFound;
import org.example.Models.*;
import org.example.Repositories.GateRepository;
import org.example.Repositories.ParkingLotRepository;
import org.example.Repositories.TicketRepository;
import org.example.Repositories.VehicleRepository;
import org.example.Strategies.ParkingSlotAllotmentStrategy.SlotAllotmentStrategy;
import org.example.Strategies.ParkingSlotAllotmentStrategy.SlotAllotmentStrategyFactory;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public ParkingTicket issueTicket (Long gateId, String vehicleNumber,
                                      String vehicleOwnerName, String licenseNumber,
                                      VehicleType vehicleType) throws GateNotFoundException, ParkingSlotNotFound {
        /**
         * 1. Create New Ticket.
         * 2. Assign Parking Slot.
         * 3. Save the ticket.
         * 4. Return the saved ticket.
         * */

        ParkingTicket parkingTicket = new ParkingTicket();

        /*------------------------Setting Gate------------------------------------*/
        Optional<Gate> gateOptional = gateRepository.findByGateId(gateId);
        if (gateOptional.isEmpty()) {
            throw new GateNotFoundException("Invalid Gate Number!! Gate Not Found.");
        }
        Gate gate = gateOptional.get();
        parkingTicket.setGate(gate);

        /*------------------------Setting Operator------------------------------------*/

        parkingTicket.setGeneratedBy(gate.getOperator());

        /*------------------------Setting Vehicle------------------------------------*/

        /*
        For getting vehicle, check if vehicle is already present in mock DB or not
        1. Yes
             -- get vehicle from DB
             -- put it in ticket object
        2. No
             -- create new vehicle
             -- save it in mock DB
             -- put it in ticket object
         */

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle savedVehicle;

        if (vehicleOptional.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setOwnerName(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setLicenseNumber(licenseNumber);

//            In case if owner might be different, so we need to add the logic
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }
        else {
            savedVehicle = vehicleOptional.get();
        }
        parkingTicket.setVehicle(savedVehicle);

        /*------------------------Setting Parking Slot------------------------------------*/

        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);
        SlotAllocationStrategyType slotAllocationStrategyType = parkingLot
                .getSlotAllocationStrategyType();
        SlotAllotmentStrategy slotAllotmentStrategy = SlotAllotmentStrategyFactory
                .getSlotStrategyForType(slotAllocationStrategyType);
        Optional<ParkingSlot> parkingSlotOptional = slotAllotmentStrategy.getSlot(gate, vehicleType);

        if (parkingSlotOptional.isEmpty()) {
            throw new ParkingSlotNotFound("Sorry!! No parking slots are Available.");
        }
        parkingTicket.setParkingSlot(parkingSlotOptional.get());

        /*------------------------Setting Entry time------------------------------------*/

        parkingTicket.setEntryTime(new Date());

        ParkingTicket savedTicket = ticketRepository.saveTicket(parkingTicket);

        /*------------------------Setting Ticket Number------------------------------------*/

//        savedTicket.setTicketNumber("Ticket no: " + savedTicket.getId() + "_"
//                + parkingSlot.getFloor().getFloorNumber() + "-" + parkingSlot.getSlotNumber()
//                + "_" + vehicleNumber);
//        Or generate a UUID
        UUID ticket_uuid = UUID.randomUUID();
        savedTicket.setTicketNumber(String.valueOf(ticket_uuid));

        return savedTicket;
    }
}
