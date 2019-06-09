package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public Organization findById(Long id) {
        logger.info(String.format("retrieving organization where id=%s", id));
        try {
            Optional<Organization> organizationOptional = organizationRepository.findById(id);
            return organizationOptional.orElse(null);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public List<Organization> findOrganizationsByField(String field, Object value) {
        logger.info(String.format("retrieving organizations where field=%s and value=%s", field, value));
        List<Organization> result = new ArrayList<>();
        try {
            result = organizationRepository.findOrganizationsByField(field, value);
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
