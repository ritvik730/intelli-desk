package com.intellidesk.ticketService.service;

import com.intellidesk.ticketService.dto.TicketDto;
import com.intellidesk.ticketService.model.Ticket;
import com.intellidesk.ticketService.model.TicketResponse;
import com.intellidesk.ticketService.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketResponse createTicket(TicketDto ticket) {

        Ticket newTicket = ticketRepository.save(ticketDtoToTicket(ticket));

        log.info("Ticket created with ID: {}", newTicket.getTicketId());
        return ticketToTicketResponse(newTicket);

    }

    public List<TicketResponse> getAllTickets() {
        log.info("Retrieving all tickets detail");
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(this::ticketToTicketResponse).toList();
    }

    public TicketResponse getTicketById(String ticketId) {
        log.info("Retrieving ticket with ID: {}", ticketId);
        Ticket ticket = ticketRepository.findByTicketId(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + ticketId));
        return ticketToTicketResponse(ticket);
    }

    public boolean deleteTicketById(String ticketId) {
        log.info("Deleting ticket with ID: {}", ticketId);
        long count = ticketRepository.deleteByTicketId(ticketId);
        return count != 0;
    }

    private Ticket ticketDtoToTicket(TicketDto ticket) {
        return Ticket.builder()
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .status(ticket.getStatus())
                .priority(ticket.getPriority())
                .assignee(ticket.getAssignee())
                .reporter(ticket.getReporter())
                .ticketId("TICKET-" + System.currentTimeMillis())
                .build();
    }

    private TicketResponse ticketToTicketResponse(Ticket ticket) {
        return TicketResponse.builder()
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .status(ticket.getStatus())
                .priority(ticket.getPriority())
                .assignee(ticket.getAssignee())
                .reporter(ticket.getReporter())
                .ticketId(ticket.getTicketId())
                .build();
    }

}
