package com.zendesk.challenge.controller;

import com.zendesk.challenge.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 *
 * <code>TicketOptionsControllerTest</code> unit test for TicketOptionsController.
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
public class TicketOptionsControllerTest {

    @Mock
    TicketService ticketService;

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
        when(ticketService.getFields()).thenReturn(Arrays.asList("field"));
        String path = ticketOptionsController.ticketOptions(map);
        assertEquals("should be ticket-options", "ticket-options", path);
    }
}
