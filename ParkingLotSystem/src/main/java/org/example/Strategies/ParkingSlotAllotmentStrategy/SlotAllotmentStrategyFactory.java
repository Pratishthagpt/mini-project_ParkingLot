package org.example.Strategies.ParkingSlotAllotmentStrategy;

import org.example.Models.ParkingSlot;
import org.example.Models.SlotAllocationStrategyType;

public class SlotAllotmentStrategyFactory {
    public static SlotAllotmentStrategy getSlotStrategyForType (SlotAllocationStrategyType slotAllocationStrategyType) {
        if (slotAllocationStrategyType.equals(SlotAllocationStrategyType.RANDOM)) {
            return new RandomSlotAllotmentStrategy();
        }
        else if (slotAllocationStrategyType.equals(SlotAllocationStrategyType.NEAREST)) {
            return new NearestSlotAllotmentStrategy();
        }
        return null;
    }
}
