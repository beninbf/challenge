package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.model.TicketModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicketBuilderTest {

    @Test
    public void testBuild() {
        TicketModel model = getTicketModel();
        Ticket ticket  = new TicketBuilder().model(model).build();
        assertNotNull("ticket should not be null", ticket);
        assertEquals("ticket id should be 11", model.getId(), ticket.getTicketId());
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
}
