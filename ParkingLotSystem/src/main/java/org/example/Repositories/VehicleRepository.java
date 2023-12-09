package org.example.Repositories;

import org.example.Models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap = new HashMap<>();
    private Long prevId = 0L;
    public Optional<Vehicle> findVehicleByNumber (String vehicleNumber) {
        if (vehicleMap.containsKey(vehicleNumber)) {
            return Optional.of(vehicleMap.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle saveVehicle (Vehicle vehicle) {
        String vehicleNum = vehicle.getVehicleNumber();
        if (!vehicleMap.containsKey(vehicleNum)) {
            prevId++;
            vehicle.setId(prevId);
            vehicleMap.put(vehicleNum, vehicle);
        }
        return vehicle;
    }
}
