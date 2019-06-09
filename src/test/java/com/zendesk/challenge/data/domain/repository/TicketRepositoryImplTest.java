package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.repository.config.RepositoryTestConfig;
import com.zendesk.challenge.util.GenericTestDataFactory;
import com.zendesk.challenge.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 *
 * <code>TicketRepositoryImplTest</code> unit test for TicketRepositoryImpl
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
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketRepositoryImplTest {

    @Inject
    TicketRepository ticketRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    OrganizationRepository organizationRepository;

    @Inject
    private TestUtil testUtil;

    @Before
    public void setUp() {
        testUtil.deleteAllRepositories();
    }

    @Test
    public void testFindById() {
        Ticket ticket = GenericTestDataFactory.getTicket();
        organizationRepository.save(ticket.getOrganization());
        userRepository.save(ticket.getAssignee());
        userRepository.save(ticket.getSubmitter());
        ticketRepository.save(ticket);
        Optional<Ticket> test = ticketRepository.findById("aaa");
        assertEquals("ticket_id should be aaa", "aaa", test.get().getId());
    }

    @Test
    public void testFindTicketsByField() {
        Ticket ticket = GenericTestDataFactory.getTicket();
        organizationRepository.save(ticket.getOrganization());
        userRepository.save(ticket.getAssignee());
        userRepository.save(ticket.getSubmitter());
        ticketRepository.save(ticket);
        List<Ticket> results = ticketRepository.findTicketsByField("id", "aaa");
        assertEquals("size should be 1", 1, results.size());
        assertEquals("ticket_id should be aaa", "aaa", results.get(0).getId());

        List<Ticket> submitterList = ticketRepository.findTicketsByField("submitter", ticket.getSubmitter().getId());
        assertEquals("size should be 1", 1, submitterList.size());
        assertEquals("submitterId should be 2", 2l, submitterList.get(0).getSubmitter().getId().longValue());

        List<Ticket> assigneeList = ticketRepository.findTicketsByField("assignee", ticket.getAssignee().getId());
        assertEquals("size should be 1", 1, assigneeList.size());
        assertEquals("assigneeId should be 4", 4l, assigneeList.get(0).getAssignee().getId().longValue());

        List<Ticket> subjectList = ticketRepository.findTicketsByField("subject", "test subject");
        assertEquals("size should be 1", 1, subjectList.size());
        assertEquals("subject should be test subject", "test subject", subjectList.get(0).getSubject());

        Ticket anotherTicket = GenericTestDataFactory.getTicket();
        anotherTicket.setId("aab");
        ticketRepository.save(anotherTicket);
        List<Ticket> externalId = ticketRepository.findTicketsByField("externalId", "abc");
        assertEquals("should be 2", 2, externalId.size());

        Ticket emptyDescriptionTicket = GenericTestDataFactory.getTicket();
        emptyDescriptionTicket.setDescription(null);
        emptyDescriptionTicket.setId("empty");
        ticketRepository.save(emptyDescriptionTicket);

        List<Ticket> emptyDescription = ticketRepository.findTicketsByField("description", null);

        Optional<Ticket> emptyTicket = ticketRepository.findById("empty");
        assertEquals("should be 1", 1, emptyDescription.size());
        assertEquals("should be empty", "empty", emptyTicket.get().getId());
        assertEquals("subject should be empty", "empty", emptyDescription.get(0).getId());
    }

    @After
    public void after() {
        testUtil.deleteAllRepositories();
    }
}