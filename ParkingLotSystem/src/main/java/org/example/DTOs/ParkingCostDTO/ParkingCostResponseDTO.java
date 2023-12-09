package org.example.DTOs.ParkingCostDTO;

import org.example.DTOs.ResponseStatus;

public class ParkingCostResponseDTO {
    private int amount;
    private ResponseStatus responseStatus;
    private String failureReason;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
