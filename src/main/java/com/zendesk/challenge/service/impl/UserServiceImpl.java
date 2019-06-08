package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    UserRepository userRepository;

    public List<User> getUsers(String field, Object value) {
        logger.info(String.format("retrieving users information %s=%s", field, value));
        return userRepository.getUsers(field, value);
    }
}
