package com.intellidesk.ticketService.repository;

import com.intellidesk.ticketService.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

    Optional<Ticket> findByTicketId(String ticketId);
    long deleteByTicketId(String ticketId);
}
