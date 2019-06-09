package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.model.TicketModel;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Test;

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
        TicketModel model = GenericTestDataFactory.getTicketModel();
        Ticket ticket  = new TicketBuilder().model(model).build();
        assertNotNull("ticket should not be null", ticket);
        assertEquals("ticket id should be 11", model.getId(), ticket.getId());
    }

    @Test
    public void testBuildModel() {
        Ticket ticket = GenericTestDataFactory.getTicket();
        TicketModel model  = new TicketBuilder().ticket(ticket).buildModel();
        assertNotNull("ticket should not be null", model);
        assertEquals("ticket id should be aaa", ticket.getId(), model.getId());
    }
}
