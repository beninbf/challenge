package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.model.TicketModel;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void testBuild() {
        TicketModel model = getTicketModel();
        Ticket ticket  = new TicketBuilder().model(model).build();
        assertNotNull("ticket should not be null", ticket);
        assertEquals("ticket id should be 11", model.getId(), ticket.getTicketId());
    }

    @Test
    public void testBuildModel() {
        Ticket ticket = getTicket();
        TicketModel model  = new TicketBuilder().ticket(ticket).buildModel();
        assertNotNull("ticket should not be null", model);
        assertEquals("ticket id should be aaa", ticket.getTicketId(), model.getId());
    }

    private TicketModel getTicketModel() {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setId("aaa");
        ticketModel.setUrl("Test");
        ticketModel.setExternalId("abc");
        ticketModel.setCreatedAt(new Date());
        ticketModel.setType("test type");
        ticketModel.setSubject("test subject");
        ticketModel.setDescription("test description");
        ticketModel.setPriority("test priority");
        ticketModel.setStatus("test status");
        ticketModel.setSubmitterId(2l);
        ticketModel.setAssigneeId(4l);
        ticketModel.setOrganizationId(5l);
        ticketModel.setVia("via");
        ticketModel.setHasIncidents(true);
        ticketModel.setTags(Arrays.asList("blah,blah,blah"));
        ticketModel.setDueAt(new Date());
        return ticketModel;
    }

    private Ticket getTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId("aaa");
        ticket.setUrl("Test");
        ticket.setExternalId("abc");
        ticket.setCreatedDate(new Timestamp(new Date().getTime()));
        ticket.setType("test type");
        ticket.setSubject("test subject");
        ticket.setDescription("test description");
        ticket.setPriority("test priority");
        ticket.setStatus("test status");
        ticket.setSubmitterId(2l);
        ticket.setAssigneeId(4l);
        ticket.setOrganizationId(5l);
        ticket.setVia("via");
        ticket.setHasIncidents(true);
        ticket.setTags(Arrays.asList("blah,blah,blah"));
        ticket.setDueDate(new Timestamp(new Date().getTime()));
        return ticket;
    }
}
