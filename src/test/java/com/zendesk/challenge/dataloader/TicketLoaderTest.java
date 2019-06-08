package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TicketLoaderTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketDataLoader ticketDataLoader;

    /**
     * Setup the UserDataLoader unit-test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        ticketDataLoader = new TicketDataLoader();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadTicketData() {
        ticketDataLoader.run(null);
        verify(ticketRepository, times(200)).save(any(Ticket.class));
    }
}