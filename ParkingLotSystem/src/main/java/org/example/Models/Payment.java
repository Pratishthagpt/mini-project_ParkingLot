package org.example.Models;

public class Payment extends BaseModel{
    private String refNumber;
    private PaymentMode paymentMode;
    private int amount;

    public Payment() {
        this.refNumber = String.valueOf(Math.random());
    }

    /*------------------------------Getters and Setters-----------------------------*/
    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
