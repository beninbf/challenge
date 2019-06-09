package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.data.domain.repository.UserRepository;
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
 * <code>TicketLoaderTest</code> unit test for TicketLoader
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
public class TicketLoaderTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrganizationRepository organizationRepository;

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
//        Optional<Organization> organization = mock(Optional.class);
//        User assignee = mock(User.class);
//        User submitter = mock(User.class);
//        when(organizationRepository.findOne(anyLong())).thenReturn(organization);
//        when(userRepository.findOne(anyLong())).thenReturn(assignee).thenReturn(submitter);
//        ticketDataLoader.run(null);
//        verify(ticketRepository, times(200)).save(any(Ticket.class));
    }
}
