package org.example.Models;

import org.example.Repositories.GateRepository;

import java.util.ArrayList;
import java.util.List;



public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private SlotAllocationStrategyType slotAllocationStrategyType;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypes;

    public ParkingLot() {
        this.name = "Drive On Park";
        this.address = "Opp. South Mall, Andheri, Mumbai, India";
        this.parkingFloors = new ArrayList<>();
        this.gates = new ArrayList<>();
        this.feeCalculationStrategyType = FeeCalculationStrategyType.NON_ELECTRIC_VEHICLE;
        this.slotAllocationStrategyType = SlotAllocationStrategyType.NEAREST;
        this.parkingLotStatus = ParkingLotStatus.OPEN;
        this.vehicleTypes = new ArrayList<>();

        inputDataToParkingLot();
    }

    public void inputDataToParkingLot() {

        int noOfFloors = 5;
        for (int i = 0; i < noOfFloors; i++) {
            parkingFloors.add(new ParkingFloor(i+1));
        }

        gates = new ArrayList<>();
        gates.addAll(GateRepository.getGatesMap().values());

        vehicleTypes.add(VehicleType.TWO_WHEELER);
        vehicleTypes.add(VehicleType.THREE_WHEELER);
        vehicleTypes.add(VehicleType.FOUR_WHEELER);
        vehicleTypes.add(VehicleType.MULTI_WHEELER);
        vehicleTypes.add(VehicleType.ELECTRIC);

    }

    /*------------------------------Getters and Setters-----------------------------*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public SlotAllocationStrategyType getSlotAllocationStrategyType() {
        return slotAllocationStrategyType;
    }

    public void setSlotAllocationStrategyType(SlotAllocationStrategyType slotAllocationStrategyType) {
        this.slotAllocationStrategyType = slotAllocationStrategyType;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
