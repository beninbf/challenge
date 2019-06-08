package com.zendesk.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * <code>TicketModel</code> model object for tickets.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class TicketModel implements Serializable {

    private static final long serialVersionUID = -4144981849731725295L;

    @JsonProperty("_id")
    private String id;

    private String url;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("created_at")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt;

    private String type;

    private String subject;

    private String description;

    private String priority;

    private String status;

    @JsonProperty("organization_id")
    private Long organizationId;

    @JsonProperty("submitter_id")
    private Long submitterId;

    @JsonProperty("assignee_id")
    private Long assigneeId;

    @JsonProperty("has_incidents")
    private Boolean hasIncidents;

    @JsonProperty("due_at")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date dueAt;

    private List<String> tags;

    private String via;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param _id the id
     */
    public void setId(String _id) {
        this.id = _id;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets status.
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
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets priority.
     *
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets priority.
     *
     * @param priority the priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
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
     * Sets created date.
     *
     * @param createdAt the created date
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * Gets organization id.
     *
     * @return the organization id
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets organization id.
     *
     * @param organization_id the organization id
     */
    public void setOrganizationId(Long organization_id) {
        this.organizationId = organization_id;
    }

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Gets suspended.
     *
     * @return the suspended
     */
    public Boolean getHasIncidents() {
        return hasIncidents;
    }

    /**
     * Sets getHasIncidents.
     *
     * @param hasIncidents the getHasIncidents
     */
    public void setHasIncidents(Boolean hasIncidents) {
        this.hasIncidents = hasIncidents;
    }

    /**
     * Gets submitter id.
     *
     * @return the submitter id
     */
    public Long getSubmitterId() {
        return submitterId;
    }

    /**
     * Sets submitter id.
     *
     * @param submitter_id the submitter id
     */
    public void setSubmitterId(Long submitter_id) {
        this.submitterId = submitter_id;
    }

    /**
     * Gets assignee id.
     *
     * @return the assignee id
     */
    public Long getAssigneeId() {
        return assigneeId;
    }

    /**
     * Sets assignee id.
     *
     * @param assignee_id the assignee id
     */
    public void setAssigneeId(Long assignee_id) {
        this.assigneeId = assignee_id;
    }

    /**
     * Gets due at.
     *
     * @return the due at
     */
    public Date getDueAt() {
        return dueAt;
    }

    /**
     * Sets due at.
     *
     * @param due_at the due at
     */
    public void setDueAt(Date due_at) {
        this.dueAt = due_at;
    }

    /**
     * Gets via.
     *
     * @return the via
     */
    public String getVia() {
        return via;
    }

    /**
     * Sets via.
     *
     * @param via the via
     */
    public void setVia(String via) {
        this.via = via;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
