package com.zendesk.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Organization model.
 */
public class OrganizationModel implements Serializable {

    private static final long serialVersionUID = -4415277210283984354L;

    @JsonProperty("_id")
    private Long id;

    private String url;

    @JsonProperty("external_id")
    private String externalId;

    private String name;

    @JsonProperty("domain_names")
    private List<String> domainNames;

    @JsonProperty("created_at")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt;

    private String details;

    @JsonProperty("shared_tickets")
    private Boolean sharedTickets;

    private List<String> tags;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param _id the id
     */
    public void setId(Long _id) {
        this.id = _id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets name.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets external id.
     *
     * @return the external id
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets external id.
     *
     * @param externalId the external id
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Gets domainNames.
     *
     * @return the domainNames
     */
    public List<String> getDomainNames() {
        return domainNames;
    }

    /**
     * Sets domainNames.
     *
     * @param domainNames the domainNames
     */
    public void setDomainNames(List<String> domainNames) {
        this.domainNames = domainNames;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets shared tickets.
     *
     * @return the shared tickets
     */
    public Boolean getSharedTickets() {
        return sharedTickets;
    }

    /**
     * Sets shared tickets.
     *
     * @param sharedTickets the shared tickets
     */
    public void setSharedTickets(Boolean sharedTickets) {
        this.sharedTickets = sharedTickets;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
