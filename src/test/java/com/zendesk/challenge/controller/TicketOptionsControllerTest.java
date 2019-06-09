package com.zendesk.challenge.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TicketOptionsControllerTest {

    @InjectMocks
    private TicketOptionsController ticketOptionsController;

    /**
     * Setup the Ticket Options Controller test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        ticketOptionsController = new TicketOptionsController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTicketOptionsController() {
        Map<String, Object> map = new HashMap<>();
        String path = ticketOptionsController.ticketOptions(map);
        assertEquals("should be ticket-options", "ticket-options", path);
    }
}
