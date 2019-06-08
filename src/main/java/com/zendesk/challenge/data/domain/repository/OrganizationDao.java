package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;

import java.util.List;

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
