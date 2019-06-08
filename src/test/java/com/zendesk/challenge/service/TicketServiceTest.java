package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.service.impl.TicketServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketServiceTest {
    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @Before
    public void setup() {
        ticketService = new TicketServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        Ticket ticket = mock(Ticket.class);
        List<Ticket> tickets = Arrays.asList(ticket);
        when(ticketRepository.getTickets(anyString(), anyString())).thenReturn(tickets);
        List<Ticket> result = ticketService.getTickets("ticketId", "id");
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }
}
