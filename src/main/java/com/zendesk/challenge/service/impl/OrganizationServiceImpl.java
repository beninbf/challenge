package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
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
 * <code>OrganizationServiceImpl</code> service implemenation for the organization service.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class OrganizationServiceImpl implements OrganizationService {
    private static Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Inject
    private OrganizationRepository organizationRepository;

    @Inject
    private BooleanValueScrubber booleanValueScrubber;

    @Inject
    private TimeFormatter timeFormatter;

    private static final String SHARED_TICKETS = "sharedTickets";

    private static final String CREATED_DATE = "createdDate";

    private static final Set<String> booleanTypes = new HashSet<>();
    {
        booleanTypes.add(SHARED_TICKETS);
    }

    public Organization findById(Long id) {
        logger.info(String.format("retrieving organization where id=%s", id));
        try {
            Optional<Organization> organizationOptional = organizationRepository.findById(id);
            Organization organization = organizationOptional.isPresent() ? organizationOptional.get() : null;
            return organization;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<Organization> findOrganizationsByField(String field, String value) {
        logger.info(String.format("retrieving organizations where field=%s and value=%s", field, value));
        List<Organization> result = new ArrayList<>();
        try {
            if (field.equals(CREATED_DATE)) {
                return organizationRepository.findOrganizationsByField(field, timeFormatter.getDateFromModelString(value));
            } else {
                Object valueToQuery = booleanValueScrubber.scrub(booleanTypes, field, value);
                return organizationRepository.findOrganizationsByField(field, valueToQuery);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return result;
    }

    public Organization save(Organization organization) {
        try {
            return organizationRepository.save(organization);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<String> getFields() {
        Organization organization = new Organization();
        Field[] fields = organization.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for(Field field: fields) {
            if (field.getName().equals("serialVersionUID")) {
                continue;
            }
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
}
