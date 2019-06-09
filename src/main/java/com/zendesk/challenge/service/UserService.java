package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.User;

import java.util.List;

/**
 *
 * <code>UserService</code> service interface for users.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface UserService {

    /**
     * Find by id.
     *
     * @param id Long
     * @return User object
     */
    User findById(Long id);

    /**
     * Get users where the field equals the value.
     * @param field String
     * @param value Object
     * @return List of users
     */
    List<User> findUsersByField(String field, Object value);

    /**
     * Find users by field and value
     * @param field String
     * @param value String
     * @return List of Users
     */
    List<User> findUsers(String field, String value);
}
