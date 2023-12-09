package org.example.Strategies.FeeCalculationStrategy;

import org.example.Models.VehicleType;

import java.util.Date;

public class NonElectricVehiclePriceCalculationStrategy implements PricingStrategy{
    @Override
    public int getParkingCost(VehicleType vehicleType, int durationOfParking) {
        if (vehicleType.equals(VehicleType.TWO_WHEELER)) {
            if (durationOfParking < 2) {
                return 20 * durationOfParking;
            }
            else return 15 * durationOfParking;
        }
        else if (vehicleType.equals(VehicleType.THREE_WHEELER)) {
            if (durationOfParking < 2) {
                return 30 * durationOfParking;
            }
            else return 20 * durationOfParking;
        }
        else if (vehicleType.equals(VehicleType.FOUR_WHEELER)) {
            if (durationOfParking < 2) {
                return 40 * durationOfParking;
            }
            else return 30 * durationOfParking;
        }
        else if (vehicleType.equals(VehicleType.MULTI_WHEELER)) {
            if (durationOfParking < 2) {
                return 50 * durationOfParking;
            }
            else return 40 * durationOfParking;
        }
        return 0;
    }
}
