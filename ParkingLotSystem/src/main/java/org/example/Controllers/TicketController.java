package org.example.Controllers;

import org.example.DTOs.IssueTicketDTO.IssueTicketRequestDTO;
import org.example.DTOs.IssueTicketDTO.IssueTicketResponseDTO;
import org.example.DTOs.ResponseStatus;
import org.example.Exceptions.GateNotFoundException;
import org.example.Exceptions.ParkingSlotNotFound;
import org.example.Models.ParkingTicket;
import org.example.Service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket (IssueTicketRequestDTO requestDTO) {
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();

        ParkingTicket ticket;

        try {
            ticket = ticketService.issueTicket(
                    requestDTO.getGateId(),
                    requestDTO.getVehicleNumber(),
                    requestDTO.getVehicleOwnerName(),
                    requestDTO.getLicenseNumber(),
                    requestDTO.getVehicleType());

        }catch (GateNotFoundException | ParkingSlotNotFound e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setFailureReason(e.getMessage());

            return responseDTO;
        }
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        responseDTO.setTicket(ticket);

        return responseDTO;
    }
}
