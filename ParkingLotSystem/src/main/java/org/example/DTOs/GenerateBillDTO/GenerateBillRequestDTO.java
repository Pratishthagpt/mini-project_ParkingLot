package org.example.DTOs.GenerateBillDTO;

import org.example.Models.Payment;

import java.util.List;

public class GenerateBillRequestDTO {
    private String ticketNumber;
    private Long gateId;
    private List<Long> paymentIds;
    private int amount;

    public GenerateBillRequestDTO(String ticketNumber, Long gateId,
                                  List<Long> paymentIds, int amount) {
        this.ticketNumber = ticketNumber;
        this.gateId = gateId;
        this.paymentIds = paymentIds;
        this.amount = amount;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public List<Long> getPaymentIds() {
        return paymentIds;
    }

    public void setPaymentIds(List<Long> paymentIds) {
        this.paymentIds = paymentIds;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
