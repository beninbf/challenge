package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


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

    public List<Organization> getOrganizations(String field, Object value) {
        logger.info(String.format("retrieving organizations where field=%s and value=%s", field, value));
        List<Organization> result = new ArrayList<>();
        try {
            result = organizationRepository.getOrganizations(field, value);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
        return result;
    }
}
