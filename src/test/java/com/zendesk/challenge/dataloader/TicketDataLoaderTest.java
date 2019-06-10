package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>TicketDataLoaderTest</code> unit test for TicketLoader
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
public class TicketDataLoaderTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private TimeFormatter timeForamtter;

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
        Organization organization = mock(Organization.class);
        User assignee = mock(User.class);
        User submitter = mock(User.class);
        when(organizationService.findById(anyLong())).thenReturn(organization);
        when(userService.findById(anyLong())).thenReturn(assignee).thenReturn(submitter);
        ticketDataLoader.run(null);
        verify(ticketService, times(200)).save(any(Ticket.class));
    }
}
