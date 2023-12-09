package org.example.Service;

import org.example.Exceptions.InvalidTicketException;
import org.example.Models.ParkingTicket;
import org.example.Models.VehicleType;
import org.example.Repositories.TicketRepository;
import org.example.Strategies.FeeCalculationStrategy.ElectricVehiclePriceCalculationStrategy;
import org.example.Strategies.FeeCalculationStrategy.NonElectricVehiclePriceCalculationStrategy;
import org.example.Strategies.FeeCalculationStrategy.PricingStrategy;

import java.util.Date;
import java.util.Optional;

public class PricingService {
    private TicketRepository ticketRepository;

    public PricingService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public int calculatePricing (String ticketNum, VehicleType vehicleType) throws InvalidTicketException {
        /**
         * 1. Get ticket from ticket number.
         * 2. Calculate fee using fee calculation strategy
         * 3. Return fee.
         * */

        Optional<ParkingTicket> ticketOptional = ticketRepository.findByTicketNumber(ticketNum);
        if (ticketOptional.isEmpty()) {
            throw new InvalidTicketException("Invalid Ticket!!");
        }
        ParkingTicket ticket = ticketOptional.get();

        Date exitTime = new Date();
        Date entryTime = ticket.getEntryTime();

        int durationOfParking = (int) ((exitTime.getTime() - entryTime.getTime()) / (60*60*1000) % 24);

        PricingStrategy pricingStrategy;
        if (vehicleType.equals(VehicleType.ELECTRIC)) {
            pricingStrategy = new ElectricVehiclePriceCalculationStrategy();
        }
        else {
            pricingStrategy = new NonElectricVehiclePriceCalculationStrategy();
        }
        int parkingCharges = pricingStrategy.getParkingCost(vehicleType, durationOfParking);

        return parkingCharges;
    }
}
