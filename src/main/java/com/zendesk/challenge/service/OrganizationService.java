package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;

import java.util.List;

/**
 * Organization Service.
 *
 * An interface for which we will retreive Organization information from storage.
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
