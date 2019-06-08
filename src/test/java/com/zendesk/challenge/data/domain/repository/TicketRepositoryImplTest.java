package com.zendesk.challenge.data.domain.repository;


import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.repository.config.RepositoryTestConfig;
import com.zendesk.challenge.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketRepositoryImplTest {

    @Inject
    TicketRepository ticketRepository;

    @Inject
    private TestUtil testUtil;

    @Before
    public void setUp() {
        testUtil.deleteAllRepositories();
    }

    @Test
    public void testGetTickets() {
        Ticket ticket = getTicket();
        ticketRepository.save(ticket);
        List<Ticket> results = ticketRepository.getTickets("ticketId", "aaa");
        Ticket test = ticketRepository.findByTicketId("aaa");
        assertEquals("size should be 1", 1, results.size());
        assertEquals("ticket_id should be aaa", "aaa", results.get(0).getTicketId());
        assertEquals("ticket_id should be aaa", "aaa", test.getTicketId());

        List<Ticket> submitterId = ticketRepository.getTickets("submitterId", 2l);
        assertEquals("size should be 1", 1, submitterId.size());
        assertEquals("submitterId should be 2", 2l, submitterId.get(0).getSubmitterId().longValue());

        List<Ticket> subject = ticketRepository.getTickets("subject", "test subject");
        assertEquals("size should be 1", 1, subject.size());
        assertEquals("subject should be test subject", "test subject", submitterId.get(0).getSubject());

        Ticket anotherTicket = getTicket();
        ticketRepository.save(anotherTicket);
        List<Ticket> externalId = ticketRepository.getTickets("externalId", "abc");
        assertEquals("should be 2", 2, externalId.size());

        Ticket emptyDescriptionTicket = getTicket();
        emptyDescriptionTicket.setDescription(null);
        emptyDescriptionTicket.setTicketId("empty");
        ticketRepository.save(emptyDescriptionTicket);
        List<Ticket> emptyDescription = ticketRepository.getTickets("description", null);
        Ticket emptyTicket = ticketRepository.findByTicketId("empty");
        assertEquals("should be 1", 1, emptyDescription.size());
        assertEquals("should be empty", "empty", emptyTicket.getTicketId());
        assertEquals("subject should be empty", "empty", emptyDescription.get(0).getTicketId());
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


    @After
    public void after() {
        testUtil.deleteAllRepositories();
    }
}