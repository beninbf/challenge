package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Ticket;

import java.util.List;

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
