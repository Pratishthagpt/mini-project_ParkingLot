package org.example;

import org.example.Controllers.GenerateBillController;
import org.example.Controllers.PricingController;
import org.example.Controllers.TicketController;
import org.example.DTOs.GenerateBillDTO.GenerateBillRequestDTO;
import org.example.DTOs.GenerateBillDTO.GenerateBillResponseDTO;
import org.example.DTOs.IssueTicketDTO.IssueTicketRequestDTO;
import org.example.DTOs.IssueTicketDTO.IssueTicketResponseDTO;
import org.example.DTOs.ParkingCostDTO.ParkingCostRequestDTO;
import org.example.DTOs.ParkingCostDTO.ParkingCostResponseDTO;
import org.example.DTOs.ResponseStatus;
import org.example.Models.PaymentMode;
import org.example.Models.VehicleType;
import org.example.Repositories.*;
import org.example.Service.GenerateBillService;
import org.example.Service.PricingService;
import org.example.Service.TicketService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParkingLotApplication {
    private static ParkingCostResponseDTO parkingCostResponseDTO;

    private static GateRepository gateRepository = new GateRepository();
    private static ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    private static VehicleRepository vehicleRepository = new VehicleRepository();
    private static TicketRepository ticketRepository = new TicketRepository();
    private static PaymentRepository paymentRepository = new PaymentRepository();
    private static BillRepository billRepository = new BillRepository();

    public static void main(String[] args) {

//        1. Issue Ticket to User
        IssueTicketResponseDTO issuedTicket = issueTicketToUser();

        if (issuedTicket.getResponseStatus().equals(ResponseStatus.FAILURE)) {
            System.out.println(issuedTicket.getFailureReason());
        }
        else {
            System.out.println(issuedTicket.getTicket().getTicketNumber());
        }

//        2. Calculate Price and return to user
        parkingCostResponseDTO = calculateFee();
        int parkingCharges = parkingCostResponseDTO.getAmount();
        System.out.println("Please pay " + parkingCharges + " as the parking charges.");

//        3. Generate Bill Receipt
        GenerateBillResponseDTO generateBillResponseDTO = generateBill();
        System.out.println("Bill id: " + generateBillResponseDTO.getGeneratedBill().getId() +
                " Ticket no: " + generateBillResponseDTO.getGeneratedBill().getTicket().getTicketNumber() +
                " Exit Time: " + generateBillResponseDTO.getGeneratedBill().getExitTime() +
                " Parking charges: " + generateBillResponseDTO.getGeneratedBill().getAmount());

    }

    private static IssueTicketRequestDTO getInputsFromUser () {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the gate Id: ");
        Long gateId = input.nextLong();

        System.out.println("Enter the vehicle number: ");
        String vehicleNum = input.next();

        System.out.println("Enter the vehicle owner name: ");
        String vehicleOwnerName = input.next();

        System.out.println("Enter the owner's license number: ");
        String licenseNum = input.next();

        VehicleType vehicleType = getVehicleTypeFromUser();

        return new IssueTicketRequestDTO(gateId,
                vehicleNum, vehicleType, licenseNum, vehicleOwnerName);
    }

    private static VehicleType getVehicleTypeFromUser () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vehicle type: (TWO_WHEELER / THREE_WHEELER / FOUR_WHEELER" +
                " / MULTI_WHEELER / ELECTRIC)");
        String type = sc.next();
        VehicleType vehicleType = VehicleType.TWO_WHEELER;

        if (type.equalsIgnoreCase("TWO_WHEELER")) {
            vehicleType = VehicleType.TWO_WHEELER;
        }
        else if (type.equalsIgnoreCase("THREE_WHEELER")) {
            vehicleType = VehicleType.THREE_WHEELER;
        }
        else if (type.equalsIgnoreCase("FOUR_WHEELER")) {
            vehicleType = VehicleType.FOUR_WHEELER;
        }
        else if (type.equalsIgnoreCase("MULTI_WHEELER")) {
            vehicleType = VehicleType.MULTI_WHEELER;
        }
        else if (type.equalsIgnoreCase("ELECTRIC")) {
            vehicleType = VehicleType.ELECTRIC;
        }
        return vehicleType;
    }

    private static IssueTicketResponseDTO issueTicketToUser () {

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository, parkingLotRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

//        Getting input from user
        IssueTicketRequestDTO ticketRequest = getInputsFromUser();

//        Start issuing tickets

        return ticketController.issueTicket(ticketRequest);
    }

    private static ParkingCostResponseDTO calculateFee () {
        PricingService pricingService = new PricingService(ticketRepository);
        PricingController pricingController = new PricingController(pricingService);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Issued Ticket Number : ");
        String ticketNum = sc.next();

        ParkingCostRequestDTO requestDTO = new ParkingCostRequestDTO(ticketNum, new Date(), getVehicleTypeFromUser());
        return pricingController.calculateParkingCostController(requestDTO);
    }

    private static GenerateBillResponseDTO generateBill () {

        GenerateBillService billService = new GenerateBillService(
                ticketRepository, paymentRepository, gateRepository, billRepository);
        GenerateBillController billController = new GenerateBillController(billService);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Issued Ticket Number : ");
        String ticketNum = sc.next();

        System.out.println("Enter the gate Id: ");
        Long gateId = sc.nextLong();

        int amount = parkingCostResponseDTO.getAmount();

        List<Long> paymentIds = new ArrayList<>();
        System.out.println("Enter the no. of partial payments done : ");
        int partialPaymentNo = sc.nextInt();

        for (int i = 0; i < partialPaymentNo; i++) {
            System.out.println("Enter the " + (i + 1) + " payment Id : ");
            Long id = sc.nextLong();
            paymentIds.add(id);

            System.out.println("Enter the payment mode : ");
            String mode = sc.next();
            PaymentMode paymentMode = PaymentMode.CASH;
            if (mode.equalsIgnoreCase("ONLINE")) {
                paymentMode = PaymentMode.ONLINE;
            }

            System.out.println("Enter the amount paid by this payment Id : ");
            int partialAmount = sc.nextInt();
            paymentRepository.savePayment(id, paymentMode, partialAmount);
        }


        GenerateBillRequestDTO requestDTO = new GenerateBillRequestDTO(
                ticketNum, gateId, paymentIds, amount);

        return billController.generateBill(requestDTO);
    }
}