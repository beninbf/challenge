package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.service.impl.TicketServiceImpl;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>TicketServiceImplTest</code> unit test for TicketService Interface
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
public class TicketServiceImplTest {
    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserService userService;

    @Mock
    private BooleanValueScrubber booleanValueScrubber;

    @InjectMocks
    private TicketService ticketService;

    @Before
    public void setup() {
        ticketService = new TicketServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        Ticket ticket = mock(Ticket.class);
        when(ticketRepository.findById(anyString())).thenReturn(Optional.of(ticket));
        Ticket result = ticketService.findById("id");
        assertNotNull("ticket is not null", result);
    }

    @Test
    public void testFindTickets_Organization() {
        Ticket ticket = mock(Ticket.class);
        List<Ticket> tickets = Arrays.asList(ticket);
        Organization organization = GenericTestDataFactory.getOrganization();
        when(organizationService.findById(anyLong())).thenReturn(organization);
        when(ticketRepository.findByOrganization(any(Organization.class))).thenReturn(tickets);

        List<Ticket> result = ticketService.findTickets("organization", "1");

        verify(ticketRepository, times(1)).findByOrganization(any(Organization.class));
        verify(organizationService, times(1)).findById(any(Long.class));
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTickets_Assignee() {
        Ticket ticket = mock(Ticket.class);
        List<Ticket> tickets = Arrays.asList(ticket);
        User user = GenericTestDataFactory.getUser(1l);
        when(userService.findById(anyLong())).thenReturn(user);
        when(ticketRepository.findByAssignee(any(User.class))).thenReturn(tickets);

        List<Ticket> result = ticketService.findTickets("assignee", "1");

        verify(ticketRepository, times(1)).findByAssignee(any(User.class));
        verify(userService, times(1)).findById(anyLong());
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTickets_Submitter() throws Exception {
        Ticket ticket = mock(Ticket.class);
        List<Ticket> tickets = Arrays.asList(ticket);
        User user = GenericTestDataFactory.getUser(1l);
        when(userService.findById(anyLong())).thenReturn(user);
        when(ticketRepository.findBySubmitter(any(User.class))).thenReturn(tickets);

        List<Ticket> result = ticketService.findTickets("submitter", "1");

        verify(ticketRepository, times(1)).findBySubmitter(any(User.class));
        verify(userService, times(1)).findById(anyLong());
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTickets_ByField() throws Exception {
        Ticket ticket = mock(Ticket.class);
        List<Ticket> tickets = Arrays.asList(ticket);
        String externalId = "test";
        when(ticketRepository.findTicketsByField(anyString(), any(Object.class))).thenReturn(tickets);
        List<Ticket> result = ticketService.findTickets("externalId", "test");

        verify(ticketRepository, times(1)).findTicketsByField(anyString(), any(Object.class));
        verify(booleanValueScrubber, times(0)).scrub(anyString(), anyString());
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTickets_Exception() throws Exception {
        Ticket ticket = mock(Ticket.class);
        String externalId = "test";
        InvalidDataAccessApiUsageException inv = mock(InvalidDataAccessApiUsageException.class);
        when(ticketRepository.findTicketsByField(anyString(), any(Object.class))).thenThrow(inv);
        List<Ticket> result = ticketService.findTickets("externalId", "test");

        verify(ticketRepository, times(1)).findTicketsByField(anyString(), any(Object.class));
        verify(booleanValueScrubber, times(0)).scrub(anyString(), anyString());
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testFindTicketsByField() throws Exception {
        Ticket ticket = mock(Ticket.class);
        List<Ticket> tickets = Arrays.asList(ticket);
        when(ticketRepository.findTicketsByField(anyString(), anyString())).thenReturn(tickets);

        List<Ticket> result = ticketService.findByTicketsByField("id", UUID.randomUUID().toString());

        verify(ticketRepository, times(1)).findTicketsByField(anyString(), anyString());
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTicketsByField_Exception() throws Exception {
        NumberFormatException nfe = mock(NumberFormatException.class);
        when(ticketRepository.findTicketsByField(anyString(), anyLong())).thenThrow(nfe);

        List<Ticket> result = ticketService.findByTicketsByField("pending", "test");

        verify(ticketRepository, times(1)).findTicketsByField(anyString(), anyString());
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testFindTicketsByOrganization() throws Exception {
        Ticket ticket = mock(Ticket.class);
        Organization organization = mock(Organization.class);
        when(organization.getId()).thenReturn(1l);
        List<Ticket> tickets = Arrays.asList(ticket);
        when(ticketRepository.findByOrganization(any(Organization.class))).thenReturn(tickets);

        List<Ticket> result = ticketService.findByOrganization(organization);

        verify(ticketRepository, times(1)).findByOrganization(any(Organization.class));
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTicketsByOrganization_Exception() {
        Organization organization = mock(Organization.class);
        when(organization.getId()).thenReturn(1l);
        InvalidDataAccessApiUsageException inv = mock(InvalidDataAccessApiUsageException.class);
        when(ticketRepository.findByOrganization(any(Organization.class))).thenThrow(inv);

        List<Ticket> result = ticketService.findByOrganization(organization);
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testFindTicketsByAssignee() {
        Ticket ticket = mock(Ticket.class);
        User user = mock(User.class);
        when(user.getId()).thenReturn(1l);
        List<Ticket> tickets = Arrays.asList(ticket);
        when(ticketRepository.findByAssignee(any(User.class))).thenReturn(tickets);

        List<Ticket> result = ticketService.findByAssignee(user);

        verify(ticketRepository, times(1)).findByAssignee(any(User.class));
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTicketsByAssignee_Exception() {
        Ticket ticket = mock(Ticket.class);
        User user = mock(User.class);
        when(user.getId()).thenReturn(1l);
        InvalidDataAccessApiUsageException inv = mock(InvalidDataAccessApiUsageException.class);
        when(ticketRepository.findByAssignee(any(User.class))).thenThrow(inv);

        List<Ticket> result = ticketService.findByAssignee(user);

        verify(ticketRepository, times(1)).findByAssignee(any(User.class));
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testFindTicketsBySubmitter() {
        Ticket ticket = mock(Ticket.class);
        User user = mock(User.class);
        when(user.getId()).thenReturn(1l);
        List<Ticket> tickets = Arrays.asList(ticket);
        when(ticketRepository.findBySubmitter(any(User.class))).thenReturn(tickets);

        List<Ticket> result = ticketService.findBySubmitter(user);

        verify(ticketRepository, times(1)).findBySubmitter(any(User.class));
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindTicketsBySubmitter_Exception() {
        User user = mock(User.class);
        when(user.getId()).thenReturn(1l);
        InvalidDataAccessApiUsageException inv = mock(InvalidDataAccessApiUsageException.class);
        when(ticketRepository.findBySubmitter(any(User.class))).thenThrow(inv);

        List<Ticket> result = ticketService.findBySubmitter(user);

        verify(ticketRepository, times(1)).findBySubmitter(any(User.class));
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testTicketSave() {
        Ticket ticket = GenericTestDataFactory.getTicket();
        ticketService.save(ticket);
        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }

    @Test
    public void testGetFields() {
        List<String> fields = ticketService.getFields();
        assertNotNull("field list should not be null", fields);
        assertTrue("field list should not be empty null", !fields.isEmpty());
    }
}
