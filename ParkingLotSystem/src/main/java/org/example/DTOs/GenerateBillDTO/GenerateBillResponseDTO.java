package org.example.DTOs.GenerateBillDTO;

import org.example.DTOs.ResponseStatus;
import org.example.Models.Bill;

public class GenerateBillResponseDTO {
    private Bill generatedBill;
    private ResponseStatus responseStatus;
    private String failureReason;

    public Bill getGeneratedBill() {
        return generatedBill;
    }

    public void setGeneratedBill(Bill generatedBill) {
        this.generatedBill = generatedBill;
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
