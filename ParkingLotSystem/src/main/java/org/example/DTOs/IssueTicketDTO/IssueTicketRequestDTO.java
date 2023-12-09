package org.example.DTOs.IssueTicketDTO;

import org.example.Models.VehicleType;

public class IssueTicketRequestDTO {
    private Long gateId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String licenseNumber;
    private String vehicleOwnerName;

    public IssueTicketRequestDTO(Long gateId, String vehicleNumber,
                                 VehicleType vehicleType,
                                 String licenseNumber,
                                 String vehicleOwnerName) {
        this.gateId = gateId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
        this.vehicleOwnerName = vehicleOwnerName;
    }

    /*------------------------------Getters and Setters-----------------------------*/
    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }
}
