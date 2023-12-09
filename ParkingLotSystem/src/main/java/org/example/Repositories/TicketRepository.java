package org.example.Repositories;

import org.example.Models.ParkingTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<Long, ParkingTicket> ticketByIdMap = new HashMap<>();
    private Map<String, ParkingTicket> ticketByNumberMap = new HashMap<>();
    private Long prevId = 0L;

    public ParkingTicket saveTicket (ParkingTicket ticket) {
        prevId++;
        ticket.setId(prevId);
        ticketByIdMap.put(prevId, ticket);
        return ticket;
    }

    public Optional<ParkingTicket> findByTicketNumber (String ticketNum) {
        if (ticketByNumberMap.containsKey(ticketNum)) {
            return Optional.of(ticketByNumberMap.get(ticketNum));
        }
        return Optional.empty();
    }
}
