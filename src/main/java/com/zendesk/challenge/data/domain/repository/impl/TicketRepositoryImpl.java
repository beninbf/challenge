package com.zendesk.challenge.data.domain.repository.impl;

import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * <code>TicketRepositoryImpl</code> implementation of the TicketRepository interface.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class TicketRepositoryImpl implements TicketDao {

    @Autowired
    private EntityManager em;

    public List<Ticket> getTickets(String field, Object value) throws NumberFormatException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        Root<Ticket> ticket = cq.from(Ticket.class);
        Expression<String> fieldExpression = ticket.get(field);
        if (value == null) {
            cq.where(cb.isNull(fieldExpression));
            TypedQuery<Ticket> query = em.createQuery(cq);
            List<Ticket> results = query.getResultList();
            return results;
        } else {
            Predicate fieldPredicate = cb.equal(ticket.get(field), value);
            cq.where(fieldPredicate);
            TypedQuery<Ticket> query = em.createQuery(cq);
            List<Ticket> results = query.getResultList();
            return results;
        }
    }
}
