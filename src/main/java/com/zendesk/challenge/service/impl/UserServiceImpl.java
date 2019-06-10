package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.DbFieldPredicate;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private TimeFormatter timeFormatter;

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
        boolean isBooleanField = DbFieldPredicate.isBooleanField().test(field);
        boolean isTimeField = DbFieldPredicate.isTimeField().test(field);
        boolean isOrganizationField = DbFieldPredicate.isOrganizationField().test(field);
        try {
            if (isOrganizationField) {
                logger.info("query by organization");
                Organization organization = organizationService.findById(getLong(value));
                List<User> results = organization != null ? userRepository.findByOrganization(organization) : new ArrayList<>();
                return results;
            } else if (isTimeField) {
                logger.info(String.format("query by date field=%s", field));
                return findUsersByField(field, timeFormatter.getDateFromModelString(value));
            } else if (isBooleanField) {
                logger.info(String.format("query by boolean field=%s", field));
                return findUsersByField(field, booleanValueScrubber.scrub(field, value));
            } else {
                logger.info(String.format("query by generic field=%s", field));
                Object valueToQuery = value.isEmpty() ? null : value;
                return findUsersByField(field, valueToQuery);
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
