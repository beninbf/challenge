package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private static Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Inject
    TicketRepository ticketRepository;

    public List<Ticket> getTickets(String field, Object value) {
        logger.info(String.format("retrieving tickets information %s=%s", field, value));
        return ticketRepository.getTickets(field, value);
    }

}
