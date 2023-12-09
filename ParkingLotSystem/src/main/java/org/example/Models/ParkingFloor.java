package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private List<ParkingSlot> parkingSlots;
    private int capacity;
    private ParkingFloorStatus parkingFloorStatus;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.capacity = 200;
        this.parkingFloorStatus = ParkingFloorStatus.OPEN;

        this.parkingSlots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            parkingSlots.add(new ParkingSlot(i+1, this));
        }
    }

    /*------------------------------Getters and Setters-----------------------------*/
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
