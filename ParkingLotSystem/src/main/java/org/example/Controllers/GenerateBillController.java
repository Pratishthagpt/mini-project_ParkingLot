package org.example.Controllers;

import org.example.DTOs.GenerateBillDTO.GenerateBillRequestDTO;
import org.example.DTOs.GenerateBillDTO.GenerateBillResponseDTO;
import org.example.DTOs.ResponseStatus;
import org.example.Exceptions.GateNotFoundException;
import org.example.Exceptions.InvalidTicketException;
import org.example.Models.Bill;
import org.example.Service.GenerateBillService;

public class GenerateBillController {
    private GenerateBillService billService;

    public GenerateBillController(GenerateBillService billService) {
        this.billService = billService;
    }

    public GenerateBillResponseDTO generateBill(GenerateBillRequestDTO requestDTO) {

        GenerateBillResponseDTO responseDTO = new GenerateBillResponseDTO();

        Bill bill;

        try {
            bill = billService.generateBill(requestDTO.getTicketNumber(),
                    requestDTO.getGateId(), requestDTO.getPaymentIds(), requestDTO.getAmount());

        } catch (InvalidTicketException | GateNotFoundException e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setFailureReason(e.getMessage());

            return responseDTO;
        }

        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        responseDTO.setGeneratedBill(bill);

        return responseDTO;
    }
}
