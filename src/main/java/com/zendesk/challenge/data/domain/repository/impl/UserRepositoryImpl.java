package com.zendesk.challenge.data.domain.repository.impl;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserDao;
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
 * <code>UserRepositoryImpl</code> implementation of the UserRepository Interface.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class UserRepositoryImpl implements UserDao {

    @Autowired
    private EntityManager em;

    public List<User> findUsersByField(String field, Object value) throws NumberFormatException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        Expression<String> fieldExpression = user.get(field);
        if (value == null) {
            cq.where(cb.isNull(fieldExpression));
            TypedQuery<User> query = em.createQuery(cq);
            List<User> results = query.getResultList();
            return results;
        } else {
            Predicate fieldPredicate = cb.equal(user.get(field), value);
            cq.where(fieldPredicate);
            TypedQuery<User> query = em.createQuery(cq);
            List<User> results = query.getResultList();
            return results;
        }
    }
}
