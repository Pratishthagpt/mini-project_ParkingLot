package org.example.Controllers;

import org.example.DTOs.ParkingCostDTO.ParkingCostRequestDTO;
import org.example.DTOs.ParkingCostDTO.ParkingCostResponseDTO;
import org.example.DTOs.ResponseStatus;
import org.example.Exceptions.InvalidTicketException;
import org.example.Service.PricingService;

public class PricingController {
    private PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public ParkingCostResponseDTO calculateParkingCostController (ParkingCostRequestDTO requestDTO) {
        ParkingCostResponseDTO responseDTO = new ParkingCostResponseDTO();

        int parkingCost;
        try {
            parkingCost = pricingService.calculatePricing(requestDTO.getTicketNum()
                    , requestDTO.getVehicleType());

        } catch (InvalidTicketException e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setFailureReason(e.getMessage());

            return responseDTO;
        }

        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        responseDTO.setAmount(parkingCost);

        return responseDTO;
    }

}
