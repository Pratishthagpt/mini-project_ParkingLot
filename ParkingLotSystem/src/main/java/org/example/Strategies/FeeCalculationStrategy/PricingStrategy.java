package org.example.Strategies.FeeCalculationStrategy;

import org.example.Models.VehicleType;

import java.util.Date;

public interface PricingStrategy {
    public int getParkingCost(VehicleType vehicleType, int durationOfParking);
}
