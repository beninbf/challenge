package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.User;

import java.util.List;

/**
 *
 * <code>UserDao</code> custom dao for querying users.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface UserDao {

    /**
     * findUsersByField - Queries for users based on a field and a value.
     *
     * @param field String
     * @param value Object
     * @return List of Users
     */
    List<User> findUsersByField(String field, Object value);
}
