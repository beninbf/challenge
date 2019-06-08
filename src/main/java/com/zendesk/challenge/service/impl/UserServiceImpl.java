package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <code>UserServiceImpl</code> service implemenation for the user service.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    UserRepository userRepository;

    public List<User> getUsers(String field, Object value) {
        logger.info(String.format("retrieving users information %s=%s", field, value));
        List<User> users = null;
        try {
            users = userRepository.getUsers(field, value);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return users;
    }
}
