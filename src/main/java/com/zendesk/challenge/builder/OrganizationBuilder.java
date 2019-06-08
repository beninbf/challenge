package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * <code>OrganizationBuilder</code> Builder class for building Organization JPA object and OrganizationModels
 *
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class OrganizationBuilder {

    private OrganizationModel model;

    private Organization organization;

    public OrganizationBuilder model(OrganizationModel model) {
        this.model = model;
        return this;
    }

    public OrganizationBuilder organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Organization build() {
        if (model != null) {
            Organization organization = new Organization();
            organization.setOrganizationId(model.getId());
            organization.setUrl(model.getUrl());
            organization.setExternalId(model.getExternalId());
            organization.setName(model.getName());
            organization.setDomainNames(model.getDomainNames());
            if (model.getCreatedAt() != null) {
                organization.setCreatedDate(new Timestamp(model.getCreatedAt().getTime()));
            }
            organization.setDetails(model.getDetails());
            organization.setSharedTickets(model.getSharedTickets());
            organization.setTags(model.getTags());
            return organization;
        } else {
            throw new IllegalArgumentException("OrganizationModel must be set to create an orgnization db object");
        }
    }

    public OrganizationModel buildModel() {
        if (organization != null) {
            OrganizationModel model = new OrganizationModel();
            model.setId(organization.getOrgnizationId());
            model.setUrl(organization.getUrl());
            model.setExternalId(organization.getExternalId());
            model.setName(organization.getName());
            model.setDomainNames(organization.getDomainNames());
            if (organization.getCreatedDate() != null) {
                model.setCreatedAt(new Date(organization.getCreatedDate().getTime()));
            }
            model.setDetails(organization.getDetails());
            model.setSharedTickets(organization.isSharedTickets());
            model.setTags(organization.getTags());
            return model;
        } else {
            throw new IllegalArgumentException("Organization must be set to create an orgnization model object");
        }
    }
}
