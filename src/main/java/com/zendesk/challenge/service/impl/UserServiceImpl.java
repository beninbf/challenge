package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    private static final String VERIFIED = "verified";

    private static final String ACTIVE = "active";

    private static final String SHARED = "shared";

    private static final String SUSPENDED = "suspended";

    private static final String ORGANIZATION = "organization";

    private static final String CREATED_DATE = "createdDate";

    private static final String LAST_LOGIN_DATE = "lastLoginDate";

    @Inject
    private TimeFormatter timeFormatter;

    private static final Set<String> booleanFields = new HashSet<>();
    {
        booleanFields.add(VERIFIED);
        booleanFields.add(ACTIVE);
        booleanFields.add(SHARED);
        booleanFields.add(SUSPENDED);
    }

    private static final Set<String> timeFields = new HashSet<>();
    {
        timeFields.add(CREATED_DATE);
        timeFields.add(LAST_LOGIN_DATE);
    }

    @Inject
    UserRepository userRepository;

    @Inject
    private BooleanValueScrubber booleanValueScrubber;

    @Inject
    private OrganizationService organizationService;

    public User findById(Long id) {
        logger.info(String.format("retrieving user where id=%s", id));
        try {
            Optional<User> userOptional = userRepository.findById(id);
            User user = userOptional.isPresent() ? userOptional.get() : null;
            return user;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<User> findUsersByField(String field, Object value) {
        logger.info(String.format("retrieving users where field=%s and value=%s", field, value));
        try {
            return userRepository.findUsersByField(field, value);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public List<User> findUsers(String field, String value) {
        try {
            if (field.equals(ORGANIZATION)) {
                logger.info("query by organization");
                Organization organization = organizationService.findById(getLong(value));
                if (organization == null) {
                    return new ArrayList<>();
                }
                return userRepository.findByOrganization(organization);
            } else {
                if (timeFields.contains(field)) {
                    return findUsersByField(field, timeFormatter.getDateFromModelString(value));
                } else {
                    Object valueToQuery = booleanValueScrubber.scrub(booleanFields, field, value);
                    return findUsersByField(field, valueToQuery);
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }

    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<String> getFields() {
        User user = new User();
        Field[] fields = user.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for(Field field: fields) {
            if (field.getName().equals("serialVersionUID")) {
                continue;
            }
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }

    private Long getLong(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException nfe) {
            logger.error(nfe.getMessage(), nfe);
            return null;
        }
    }
}
