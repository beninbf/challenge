package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;

import java.util.List;

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
