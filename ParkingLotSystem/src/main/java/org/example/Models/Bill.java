package org.example.Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private ParkingTicket ticket;
    private Date exitTime;
    private int amount;
    private List<Payment> paymentList;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private Gate gate;

    /*------------------------------Getters and Setters-----------------------------*/
    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
