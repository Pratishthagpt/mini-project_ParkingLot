package org.example.Models;

import java.util.Date;

public class ElectricPanel extends BaseModel{
    private ParkingSlot parkingSlot;
    private Payment payment;
    private Date chargingTime;
    private Vehicle vehicle;


    /*------------------------------Getters and Setters-----------------------------*/

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(Date chargingTime) {
        this.chargingTime = chargingTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
