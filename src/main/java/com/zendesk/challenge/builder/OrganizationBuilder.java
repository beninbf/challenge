package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.service.TimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static Logger logger = LoggerFactory.getLogger(OrganizationBuilder.class);

    private OrganizationModel model;

    private Organization organization;

    private TimeFormatter timeFormatter;

    public OrganizationBuilder model(OrganizationModel model) {
        this.model = model;
        return this;
    }

    public OrganizationBuilder organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public OrganizationBuilder timeFormatter(TimeFormatter timeFormatter) {
        this.timeFormatter = timeFormatter;
        return this;
    }

    public Organization build() {
        if (model != null && timeFormatter != null) {
            Organization organization = new Organization();
            organization.setId(model.getId());
            organization.setUrl(model.getUrl());
            organization.setExternalId(model.getExternalId());
            organization.setName(model.getName());
            organization.setDomainNames(model.getDomainNames());
            if (model.getCreatedAt() != null) {
                organization.setCreatedDate(timeFormatter.getDateFromString(model.getCreatedAt()));
            }
            organization.setDetails(model.getDetails());
            organization.setSharedTickets(model.getSharedTickets());
            organization.setTags(model.getTags());
            return organization;
        } else {
            throw new IllegalArgumentException("OrganizationModel and TimeFormatter must be set to create an orgnization db object");
        }
    }

    public OrganizationModel buildModel() {
        if (organization != null && timeFormatter != null) {
            OrganizationModel model = new OrganizationModel();
            model.setId(organization.getId());
            model.setUrl(organization.getUrl());
            model.setExternalId(organization.getExternalId());
            model.setName(organization.getName());
            model.setDomainNames(organization.getDomainNames());
            if (organization.getCreatedDate() != null) {
                model.setCreatedAt(timeFormatter.getStringFromTimeStamp(organization.getCreatedDate()));
            }
            model.setDetails(organization.getDetails());
            model.setSharedTickets(organization.isSharedTickets());
            model.setTags(organization.getTags());
            return model;
        } else {
            throw new IllegalArgumentException("Organization and TimeFormatter must be set to create an organization model object");
        }
    }
}
