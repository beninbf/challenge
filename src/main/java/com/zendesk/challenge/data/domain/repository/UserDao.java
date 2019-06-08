package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.User;

import java.util.List;

public interface UserDao {

    /**
     * getUsers - Queries for users based on a field and a value.
     *
     * @param field String
     * @param value Object
     * @return List of Users
     */
    List<User> getUsers(String field, Object value);
}
