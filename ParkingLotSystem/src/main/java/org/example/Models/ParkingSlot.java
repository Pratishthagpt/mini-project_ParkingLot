package org.example.Models;

public class ParkingSlot extends BaseModel{
    private int slotNumber;
    private ParkingFloor floor;
    private Vehicle vehicle;
    private ParkingSlotType slotType;
    private ParkingSlotStatus parkingSlotStatus;

    public ParkingSlot(int slotNumber, ParkingFloor floor) {
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.vehicle = null;
        this.slotType = ParkingSlotType.MEDIUM;
        this.parkingSlotStatus = ParkingSlotStatus.AVAILABLE;
    }

    /*------------------------------Getters and Setters-----------------------------*/
    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(ParkingSlotType slotType) {
        this.slotType = slotType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
