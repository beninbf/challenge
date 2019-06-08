package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;

import java.util.List;

/**
 *
 * <code>OrganizationService</code> service interface for organizations.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface OrganizationService {

    /**
     * Get organizations where the field matches the value.
     *
     * @param field String
     * @param value Object
     * @return list of organizations
     */
    List<Organization> getOrganizations(String field, Object value);
}
