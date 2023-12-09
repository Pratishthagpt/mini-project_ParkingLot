package org.example.Strategies.FeeCalculationStrategy;

import org.example.Models.VehicleType;

import java.util.Date;

public class ElectricVehiclePriceCalculationStrategy implements PricingStrategy{
    @Override
    public int getParkingCost(VehicleType vehicleType, int durationOfCharging) {
        if (vehicleType.equals(VehicleType.ELECTRIC)) {
            return 15 * durationOfCharging;
        }
        return 0;
    }
}
