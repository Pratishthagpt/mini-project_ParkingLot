package org.example.Models;

public class Gate extends BaseModel{
    private int gateNumber;
    private GateType gateType;
    private Operator operator;

    public Gate(int gateNumber, GateType gateType, Operator operator) {
        this.gateNumber = gateNumber;
        this.gateType = gateType;
        this.operator = operator;
    }

    /*------------------------------Getters and Setters-----------------------------*/
    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
