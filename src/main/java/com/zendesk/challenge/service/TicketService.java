package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;

import java.util.List;


/**
 *
 * <code>TicketService</code> service interface for tickets.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface TicketService {

    /**
     * Find tickets.
     *
     * @param field String
     * @param value String
     * @return List of tickets
     */
    public List<Ticket> findTickets(String field, String value);

    /**
     * Get tickets where the field matches the value.
     *
     * @param field String
     * @param value Object
     * @return List of tickets
     */
    public List<Ticket> findByTicketsByField(String field, Object value);

    /**
     * Find tickets by organization.
     *
     * @param organization organization
     * @return List of tickets
     */
    public List<Ticket> findByOrganization(Organization organization);

    /**
     * Find tickets by assignee.
     *
     * @param assignee User
     * @return List of tickets
     */
    public List<Ticket> findByAssignee(User assignee);

    /**
     * Find tickets by submitter.
     *
     * @param submitter User
     * @return List of tickets
     */
    public List<Ticket> findBySubmitter(User submitter);
}
