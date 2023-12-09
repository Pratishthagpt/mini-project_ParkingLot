package org.example.DTOs.ParkingCostDTO;

import org.example.Models.VehicleType;

import java.util.Date;

public class ParkingCostRequestDTO {
    private String ticketNum;
    private VehicleType vehicleType;

    public ParkingCostRequestDTO(String ticketNum, Date exitTime, VehicleType vehicleType) {
        this.ticketNum = ticketNum;
        this.vehicleType = vehicleType;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
