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
     * Find by id.
     *
     * @param id Long
     * @return organization
     */
    Organization findById(Long id);

    /**
     * Get organizations where the field matches the value.
     *
     * @param field String
     * @param value Object
     * @return list of organizations
     */
    List<Organization> findOrganizationsByField(String field, String value);

    /**
     * Save an organization to storage.
     *
     * @param organization Organization
     * @return Organization
     */
    Organization save(Organization organization);

    /**
     * Get fields of Organization Db object.
     *
     * @return List of Strings
     */
    List<String> getFields();
}
