package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * <code>TicketServiceImpl</code> service implemenation for the ticket service.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class TicketServiceImpl implements TicketService {

    private static Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    private static final String HAS_INCIDENTS = "hasIncidents";

    private static final String ORGANIZATION = "organization";

    private static final String ASSIGNEE = "assignee";

    private static final String SUBMITTER = "submitter";

    private static final Set<String> booleanTypes = new HashSet<>();
    {
        booleanTypes.add(HAS_INCIDENTS);
    }

    @Inject
    TicketRepository ticketRepository;

    @Inject
    private OrganizationService organizationService;

    @Inject
    private UserService userService;

    @Inject
    private BooleanValueScrubber booleanValueScrubber;

    public List<Ticket> findTickets(String field, String value) {
        try {
            if (field.equals(ORGANIZATION)) {
                logger.info("query by organization");
                Organization organization = organizationService.findById(Long.valueOf(value));
                return findByOrganization(organization);
            } else if (field.equals(ASSIGNEE)) {
                logger.info("query by assignee");
                User assignee = userService.findById(Long.valueOf(value));
                return findByAssignee(assignee);
            } else if (field.equals(SUBMITTER)) {
                logger.info("query by submitter");
                User submitter = userService.findById(Long.valueOf(value));
                return findBySubmitter(submitter);
            } else {
                Object valueToQuery = booleanValueScrubber.scrub(booleanTypes, field, value);
                return findByTicketsByField(field, valueToQuery);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<Ticket> findByTicketsByField(String field, Object value) {
        logger.info(String.format("retrieving tickets where field=%s and value=%s", field, value));
        List<Ticket> tickets = null;
        try {
            tickets = ticketRepository.findTicketsByField(field, value);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tickets;
    }

    public List<Ticket> findByOrganization(Organization organization) {
        logger.info(String.format("retrieving by organization=%s", organization.getId()));
        List<Ticket> tickets = null;
        try {
            tickets = ticketRepository.findByOrganization(organization);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tickets;
    }

    public List<Ticket> findByAssignee(User assignee) {
        logger.info(String.format("retrieving tickets by assignee=%s", assignee.getId()));
        List<Ticket> tickets = null;
        try {
            tickets = ticketRepository.findByAssignee(assignee);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tickets;
    }

    public List<Ticket> findBySubmitter(User submitter) {
        logger.info(String.format("retrieving tickets by submitter=%s", submitter.getId()));
        List<Ticket> tickets = null;
        try {
            tickets = ticketRepository.findBySubmitter(submitter);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return tickets;
    }

    public Ticket save(Ticket ticket) {
        try {
            return ticketRepository.save(ticket);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<String> getFields() {
        Ticket ticket = new Ticket();
        Field[] fields = ticket.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for(Field field: fields) {
            if (field.getName().equals("serialVersionUID")) {
                continue;
            }
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
}
