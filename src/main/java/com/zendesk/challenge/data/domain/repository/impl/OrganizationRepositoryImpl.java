package com.zendesk.challenge.data.domain.repository.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.Ticket;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.OrganizationDao;
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
 * <code>OrganizationRepositoryImpl</code> implementation of the OrganizationRepository Interface.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class OrganizationRepositoryImpl implements OrganizationDao {

    @Autowired
    private EntityManager em;

    public List<Organization> findOrganizationsByField(String field, Object value) throws NumberFormatException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> cq = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = cq.from(Organization.class);
        Expression<String> fieldExpression = organizationRoot.get(field);
        if (value == null) {
            cq.where(cb.isNull(fieldExpression));
            TypedQuery<Organization> query = em.createQuery(cq);
            List<Organization> results = query.getResultList();
            return results;
        } else {
            Predicate fieldPredicate = cb.equal(organizationRoot.get(field), value);
            cq.where(fieldPredicate);
            TypedQuery<Organization> query = em.createQuery(cq);
            List<Organization> results = query.getResultList();
            return results;
        }
    }
}
