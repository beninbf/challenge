package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;

import java.util.List;

/**
 *
 * <code>OrganizationDao</code> custom dao for querying organizations.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface OrganizationDao {

    /**
     * getOrganizations - Queries for organizations based on a field and a value.
     *
     * @param field String
     * @param value Object
     * @return List of Organizations
     */
    List<Organization> getOrganizations(String field, Object value);
}
