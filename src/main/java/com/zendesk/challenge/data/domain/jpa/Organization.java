package com.zendesk.challenge.data.domain.jpa;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 *
 * <code>Organization</code> class is a database entity mapping to table ORGANIZATION.
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
@Entity
public class Organization implements Serializable {

    private static final long serialVersionUID = -5101095100631176305L;

    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "ORGANIZATION_ID", nullable = false)
    private Long organizationId;

    @Column(name = "URL", nullable = true, length = 100)
    private String url;

    @Column(name = "EXTERNAL_ID", nullable = true, length = 50)
    private String externalId;

    @Column(name = "NAME", nullable = true, length = 50)
    private String name;

    @Column(name = "DOMAIN_NAMES", nullable = true)
    private String domainNames;

    @Column(name = "CREATED_D", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Timestamp createdDate;

    @Column(name = "DETAILS", nullable = true, length = 50)
    private String details;

    @Column(name = "SHARED_TICKETS", columnDefinition = "TINYINT(1)", nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean sharedTickets;

    @Column(name = "TAGS", nullable = true)
    private String tags;

    /**
     * Gets unique userId.
     *
     * @return the unique userId
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets unique userId.
     *
     * @param id the unique userId
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets organizationId.
     *
     * @return the organizationId
     */
    public Long getOrgnizationId() {
        return organizationId;
    }

    /**
     * Sets organizationId.
     *
     * @param organizationId the organizationId
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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
     * Gets external userId.
     *
     * @return the external userId
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets external userId.
     *
     * @param externalId the external userId
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
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets created date.
     *
     * @param createdDate the created date
     */
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public List<String> getTags() {
        return Arrays.asList(tags.split(","));
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(List<String> tags) {
        this.tags = String.join(",", tags);
    }

    /**
     * Gets domain names.
     *
     * @return the domain names
     */
    public List<String> getDomainNames() {
        return Arrays.asList(domainNames.split(","));
    }

    /**
     * Sets domain names.
     *
     * @param domainNames the domain names
     */
    public void setDomainNames(List<String> domainNames) {
        this.domainNames = String.join(",", domainNames);
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
    public Boolean isSharedTickets() {
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
}
