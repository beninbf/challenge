package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.DbFieldPredicate;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Inject
    TicketRepository ticketRepository;

    @Inject
    private OrganizationService organizationService;

    @Inject
    private UserService userService;

    @Inject
    private TimeFormatter timeFormatter;

    @Inject
    private BooleanValueScrubber booleanValueScrubber;

    public Ticket findById(String id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.isPresent() ? ticketOptional.get() : null;
    }

    public List<Ticket> findTickets(String field, String value) {
        boolean isBooleanField = DbFieldPredicate.isBooleanField().test(field);
        boolean isTimeField = DbFieldPredicate.isTimeField().test(field);
        boolean isUserField = DbFieldPredicate.isUserField().test(field);
        boolean isAssignee = DbFieldPredicate.isAssignee().test(field);
        boolean isSubmitter = DbFieldPredicate.isSubmitter().test(field);
        boolean isOrganizationField = DbFieldPredicate.isOrganizationField().test(field);
        try {
            if (isOrganizationField) {
                Long organizationId = getLong(value);
                logger.info(String.format("query by organization=%s", organizationId));
                Organization organization = organizationService.findById(organizationId);
                return findByOrganization(organization);
            } else if (isUserField && isAssignee) {
                Long assigneeId = getLong(value);
                logger.info(String.format("query by assignee=%s", assigneeId));
                User assignee = userService.findById(assigneeId);
                return findByAssignee(assignee);
            } else if (isUserField && isSubmitter) {
                Long submitterId = getLong(value);
                logger.info(String.format("query by submitter=%s", submitterId));
                User submitter = userService.findById(submitterId);
                return findBySubmitter(submitter);
            } else if (isTimeField) {
                return findByTicketsByField(field, timeFormatter.getDateFromModelString(value));
            } else if (isBooleanField) {
                return findByTicketsByField(field, booleanValueScrubber.scrub(field, value));
            } else {
                Object valueToQuery = value.isEmpty() ? null : value;
                return findByTicketsByField(field, valueToQuery);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public List<Ticket> findByTicketsByField(String field, Object value) {
        logger.info(String.format("retrieving tickets where field=%s and value=%s", field, value));
        try {
            return ticketRepository.findTicketsByField(field, value);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public List<Ticket> findByOrganization(Organization organization) {
        logger.info(String.format("retrieving by organization=%s", organization.getId()));
        try {
            return ticketRepository.findByOrganization(organization);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public List<Ticket> findByAssignee(User assignee) {
        logger.info(String.format("retrieving tickets by assignee=%s", assignee.getId()));
        try {
            return ticketRepository.findByAssignee(assignee);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public List<Ticket> findBySubmitter(User submitter) {
        logger.info(String.format("retrieving tickets by submitter=%s", submitter.getId()));
        try {
            return ticketRepository.findBySubmitter(submitter);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
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

    private Long getLong(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Long id = Long.valueOf(value);
            return id;
        } catch (NumberFormatException nfe) {
            logger.error(nfe.getMessage(), nfe);
            return null;
        }
    }
}
