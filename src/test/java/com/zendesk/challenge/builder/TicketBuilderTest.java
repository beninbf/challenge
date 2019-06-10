package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 *
 * <code>TicketBuilderTest</code> unit test for TicketBuilder
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
public class TicketBuilderTest {

    @Mock
    private TimeFormatter timeFormatter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(timeFormatter.getDateFromString(anyString())).thenReturn(new Timestamp(new Date().getTime()));
        when(timeFormatter.getStringFromTimeStamp(any(Timestamp.class))).thenReturn(new Date().toString());
    }

    @Test
    public void testBuild() {
        TicketModel model = GenericTestDataFactory.getTicketModel();
        Organization organization = GenericTestDataFactory.getOrganization();
        User assignee = GenericTestDataFactory.getUser(2l);
        User submitter = GenericTestDataFactory.getUser(3l);
        Ticket ticket  = new TicketBuilder()
            .model(model)
            .organization(organization)
            .assignee(assignee)
            .submitter(submitter)
            .timeFormatter(timeFormatter)
            .build();

        assertNotNull("ticket should not be null", ticket);
        assertEquals("ticket id should be 11", model.getId(), ticket.getId());
        assertNotNull("url should not be null", ticket.getUrl());
        assertNotNull("externalId should not be null", ticket.getExternalId());
        assertNotNull("createdDate should not be null", ticket.getCreatedDate());
        assertNotNull("type should not be null", ticket.getType());
        assertNotNull("subject should not be null", ticket.getSubject());
        assertNotNull("description should not be null", ticket.getDescription());
        assertNotNull("priority should not be null", ticket.getPriority());
        assertNotNull("status should not be null", ticket.getStatus());
        assertNotNull("assignee should not be null", ticket.getAssignee());
        assertNotNull("submitter should not be null", ticket.getSubmitter());
        assertNotNull("organization should not be null", ticket.getOrganization());
        assertNotNull("hasIncidents should not be null", ticket.hasIncidents());
        assertNotNull("via should not be null", ticket.getVia());
        assertNotNull("dueDate should not be null", ticket.getDueDate());
        assertNotNull("tags should not be null", ticket.getTags());
    }

    @Test
    public void testBuildModel() {
        Ticket ticket = GenericTestDataFactory.getTicket();
        TicketModel model  = new TicketBuilder()
            .ticket(ticket)
            .assignee(ticket.getAssignee())
            .submitter(ticket.getSubmitter())
            .organization(ticket.getOrganization())
            .timeFormatter(timeFormatter)
            .buildModel();

        assertNotNull("ticket should not be null", model);
        assertEquals("ticket id should be aaa", ticket.getId(), model.getId());
        assertNotNull("url should not be null", model.getUrl());
        assertNotNull("externalId should not be null", model.getExternalId());
        assertNotNull("createdDate should not be null", model.getCreatedAt());
        assertNotNull("type should not be null", model.getType());
        assertNotNull("subject should not be null", model.getSubject());
        assertNotNull("description should not be null", model.getDescription());
        assertNotNull("priority should not be null", model.getPriority());
        assertNotNull("status should not be null", model.getStatus());
        assertNotNull("assignee should not be null", model.getAssigneeId());
        assertNotNull("submitter should not be null", model.getSubmitterId());
        assertNotNull("organization should not be null", model.getOrganizationId());
        assertNotNull("hasIncidents should not be null", model.getHasIncidents());
        assertNotNull("via should not be null", model.getVia());
        assertNotNull("dueDate should not be null", model.getDueAt());
        assertNotNull("tags should not be null", model.getTags());
    }
}
