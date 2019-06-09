package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * <code>TicketRepository</code> repository for querying ticket data.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
@Repository
public interface TicketRepository extends TicketDao, JpaRepository<Ticket, Long> {

    /**
     * Retrieves a ticket by the ticket id.
     *
     * @return Ticket Object
     */
    Optional<Ticket> findById(String id);

    /**
     * Retrieves a ticket by the organization.
     *
     * @return Ticket Object
     */
    List<Ticket> findByOrganization(Organization organization);

    /**
     * Retrieves a ticket by the assignee.
     *
     * @return List of Ticket Objects
     */
    List<Ticket> findByAssignee(User user);

    /**
     * Retrieves a Ticket by the submitter.
     *
     * @return List of Ticket Objects
     */
    List<Ticket> findBySubmitter(User user);
}
