package org.example.DTOs.IssueTicketDTO;

import org.example.DTOs.ResponseStatus;
import org.example.Models.ParkingTicket;

public class IssueTicketResponseDTO {
    private ParkingTicket ticket;
    private ResponseStatus responseStatus;
    private String failureReason;


    /*------------------------------Getters and Setters-----------------------------*/
    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
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
