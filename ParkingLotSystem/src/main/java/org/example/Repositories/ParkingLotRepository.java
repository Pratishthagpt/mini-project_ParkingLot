package org.example.Repositories;

import org.example.Models.Gate;
import org.example.Models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();
    private Long prevId = 0L;

    public ParkingLotRepository() {
        parkingLotMap.put(1L, new ParkingLot());
    }

    public ParkingLot findParkingLotByGate (Gate gate) {
        for (ParkingLot parkingLot : parkingLotMap.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return parkingLot;
            }
        }
        return null;
    }

    public void saveParkingLot (ParkingLot parkingLot) {
        prevId++;
        parkingLot.setId(prevId);
        parkingLotMap.put(prevId, parkingLot);
    }
}
