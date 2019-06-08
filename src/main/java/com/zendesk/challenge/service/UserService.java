package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.User;

import java.util.List;

/**
 * UserService.
 *
 * An interface for which we will retreive User information from storage.
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
