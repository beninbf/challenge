package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Ticket;

import java.util.List;


/**
 *
 * <code>TicketService</code> service interface for tickets.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface TicketService {

    /**
     * Get tickets where the field matches the value.
     *
     * @param field String
     * @param value Object
     * @return List of tickets
     */
    public List<Ticket> getTickets(String field, Object value);
}
