package org.example.Strategies.ParkingSlotAllotmentStrategy;

import org.example.Models.Gate;
import org.example.Models.ParkingSlot;
import org.example.Models.VehicleType;

import java.util.Optional;

public interface SlotAllotmentStrategy {
    public Optional<ParkingSlot> getSlot(Gate gate, VehicleType vehicleType);
}
