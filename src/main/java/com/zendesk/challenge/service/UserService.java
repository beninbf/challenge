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
     * Get users where the field equals the value.
     * @param field String
     * @param value Object
     * @return List of users
     */
    List<User> getUsers(String field, Object value);
}
