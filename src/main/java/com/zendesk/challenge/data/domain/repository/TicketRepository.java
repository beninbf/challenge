package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends TicketDao, JpaRepository<Ticket, Long> {

    /**
     * Retrieves a user by the ticket id.
     *
     * @return Ticket Object
     */
    Ticket findByTicketId(String id);
}
