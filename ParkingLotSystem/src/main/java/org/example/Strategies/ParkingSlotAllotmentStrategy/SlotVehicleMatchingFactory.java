package org.example.Strategies.ParkingSlotAllotmentStrategy;

import org.example.Models.ParkingSlot;
import org.example.Models.ParkingSlotStatus;
import org.example.Models.ParkingSlotType;
import org.example.Models.VehicleType;

import java.util.Optional;

public class SlotVehicleMatchingFactory {
    public static Optional<ParkingSlot> slotMatchesVehicle (VehicleType vehicleType, ParkingSlot parkingSlot) {
        if ((vehicleType.equals(VehicleType.TWO_WHEELER)
                && parkingSlot.getSlotType().equals(ParkingSlotType.COMPACT)) ||
                (vehicleType.equals(VehicleType.THREE_WHEELER)
                        && parkingSlot.getSlotType().equals(ParkingSlotType.MEDIUM)) ||
                (vehicleType.equals(VehicleType.FOUR_WHEELER)
                        && parkingSlot.getSlotType().equals(ParkingSlotType.MEDIUM)) ||
                (vehicleType.equals(VehicleType.MULTI_WHEELER)
                        && parkingSlot.getSlotType().equals(ParkingSlotType.LARGE)) ||
                (vehicleType.equals(VehicleType.ELECTRIC)
                        && parkingSlot.getSlotType().equals(ParkingSlotType.ELECTRIC))) {
            parkingSlot.setParkingSlotStatus(ParkingSlotStatus.BOOKED);
            return Optional.of(parkingSlot);
        }
        return Optional.empty();
    }
}
