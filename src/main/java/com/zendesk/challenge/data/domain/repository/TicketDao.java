package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Ticket;

import java.util.List;

/**
 *
 * <code>TicketDao</code> custom dao for querying tickets.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface TicketDao {

    /**
     * getTickets - Queries for tickets based on a field and a value.
     *
     * @param field String
     * @param value Object
     * @return List of Users
     */
    List<Ticket> getTickets(String field, Object value);
}
