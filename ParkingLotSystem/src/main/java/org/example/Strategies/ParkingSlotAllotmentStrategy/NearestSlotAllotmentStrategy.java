package org.example.Strategies.ParkingSlotAllotmentStrategy;

import org.example.Models.*;
import org.example.Repositories.ParkingLotRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class NearestSlotAllotmentStrategy implements SlotAllotmentStrategy {
    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    @Override
    public Optional<ParkingSlot> getSlot(Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for (ParkingFloor parkingFloor : parkingFloors) {
            for (ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
                if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
                    return SlotVehicleMatchingFactory.slotMatchesVehicle(vehicleType, parkingSlot);
                }
            }
        }

        return Optional.empty();
    }

}
