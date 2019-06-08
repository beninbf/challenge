package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * <code>TicketRepository</code> repository for querying ticket data.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
@Repository
public interface TicketRepository extends TicketDao, JpaRepository<Ticket, Long> {

    /**
     * Retrieves a user by the ticket id.
     *
     * @return Ticket Object
     */
    Ticket findByTicketId(String id);
}
