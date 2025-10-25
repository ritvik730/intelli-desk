package com.intellidesk.ticketService.controller;

import com.intellidesk.ticketService.dto.TicketDto;
import com.intellidesk.ticketService.model.TicketResponse;
import com.intellidesk.ticketService.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public TicketResponse createTicket(@RequestBody TicketDto ticket) {

        // apply some validation logic here
        log.info("request received to create ticket: {}", ticket);
        return ticketService.createTicket(ticket);


    }

    @GetMapping
    public List<TicketResponse> getAllTickets() {

        return ticketService.getAllTickets();
    }

    @GetMapping("/{ticketId}")
    public TicketResponse getTicketById(@PathVariable String ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @DeleteMapping("/{ticketId}")
    public Boolean deleteTicketById(@PathVariable String ticketId) {
        return ticketService.deleteTicketById(ticketId);
    }
}
