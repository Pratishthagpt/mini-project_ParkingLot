package org.example.Strategies.ParkingSlotAllotmentStrategy;

import org.example.Models.*;
import org.example.Repositories.ParkingLotRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomSlotAllotmentStrategy implements SlotAllotmentStrategy{
    private ParkingLotRepository parkingLotRepository;
    @Override
    public Optional<ParkingSlot> getSlot(Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotRepository.findParkingLotByGate(gate);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for (ParkingFloor parkingFloor : parkingFloors) {
            Random random = new Random();
            int slotNum = random.nextInt(parkingFloor.getParkingSlots().size() + 1) + 1;
            for (ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {

                if (slotNum == parkingSlot.getSlotNumber()
                        && parkingSlot.getParkingSlotStatus()
                        .equals(ParkingSlotStatus.AVAILABLE)) {
                    return SlotVehicleMatchingFactory.slotMatchesVehicle(vehicleType, parkingSlot);
                }
            }
        }
        return Optional.empty();
    }
}
