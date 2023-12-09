package org.example.Service;

import org.example.Exceptions.GateNotFoundException;
import org.example.Exceptions.InvalidTicketException;
import org.example.Models.*;
import org.example.Repositories.BillRepository;
import org.example.Repositories.GateRepository;
import org.example.Repositories.PaymentRepository;
import org.example.Repositories.TicketRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GenerateBillService {
    private TicketRepository ticketRepository;
    private PaymentRepository paymentRepository;
    private GateRepository gateRepository;
    private BillRepository billRepository;

    public GenerateBillService(TicketRepository ticketRepository,
                               PaymentRepository paymentRepository,
                               GateRepository gateRepository,
                               BillRepository billRepository) {
        this.ticketRepository = ticketRepository;
        this.paymentRepository = paymentRepository;
        this.gateRepository = gateRepository;
        this.billRepository = billRepository;
    }

    public Bill generateBill (String ticketNum, Long gateId,
                              List<Long> paymentIds, int amount) throws InvalidTicketException, GateNotFoundException {
        /**
         * 1. Generate new Bill
         * 2. Get ticket from ticketNum
         * 3. Get gate from gateId
         * 4. Map payment ref no. with the payment modes and get the list of payment
         * 5. Get parkingCost pricing amount
         * 6. Save all to bill generated object
         * 7. Return the saved Bill.
         * */
        Bill bill = new Bill();

        /*------------------------Setting ticket------------------------------------*/

        Optional<ParkingTicket> ticketOptional = ticketRepository.findByTicketNumber(ticketNum);
        if (ticketOptional.isEmpty()) {
            throw new InvalidTicketException("Invalid Ticket!!");
        }
        ParkingTicket ticket = ticketOptional.get();
        bill.setTicket(ticket);


        /*------------------------Setting Gate------------------------------------*/
        Optional<Gate> gateOptional = gateRepository.findByGateId(gateId);
        if (gateOptional.isEmpty()) {
            throw new GateNotFoundException("Invalid Gate Number!! Gate Not Found.");
        }
        Gate gate = gateOptional.get();
        bill.setGate(gate);


        /*------------------------Setting Partial payment List------------------------------------*/
        List<Payment> paymentList = new ArrayList<>();
        for (Long id : paymentIds) {
            paymentList.add(paymentRepository.findById(id));
        }
        bill.setPaymentList(paymentList);


        /*------------------------Setting Exit time and amount------------------------------------*/

        bill.setExitTime(new Date());

        bill.setAmount(amount);


        /*------------------------Setting Fee Calculation strategy type------------------------------------*/
        FeeCalculationStrategyType feeCalculationStrategyType;
        if (ticket.getVehicle().getVehicleType().equals(VehicleType.ELECTRIC)) {
            feeCalculationStrategyType = FeeCalculationStrategyType.ELECTRIC_VEHICLE;
        }
        else {
            feeCalculationStrategyType = FeeCalculationStrategyType.NON_ELECTRIC_VEHICLE;
        }
        bill.setFeeCalculationStrategyType(feeCalculationStrategyType);

        Bill savedBill = billRepository.saveBill(bill);

        return savedBill;
    }
}
