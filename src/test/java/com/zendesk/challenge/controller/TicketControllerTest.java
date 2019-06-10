package com.zendesk.challenge.controller;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>TicketControllerTest</code> unit test for TicketController.
 *
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class TicketControllerTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private TimeFormatter timeFormatter;

    @InjectMocks
    private TicketController ticketController;

    /**
     * Setup the User Controller test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        ticketController = new TicketController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTicket() {
        Map<String, Object> modelMap = new HashMap<>();
        Ticket ticket = mock(Ticket.class);
        when(ticketService.findTickets(anyString(), anyString())).thenReturn(Arrays.asList(GenericTestDataFactory.getTicket()));
        String path = ticketController.ticket("id", "100", modelMap);
        assertEquals("should be user", "ticket", path);
        verify(ticketService, times(1)).findTickets(anyString(), anyString());
    }
}
