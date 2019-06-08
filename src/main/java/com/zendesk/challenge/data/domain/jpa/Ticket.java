package com.zendesk.challenge.data.domain.jpa;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 *
 * <code>Ticket</code> class is a database entity mapping to table TICKET.
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
public class Ticket {

    private static final long serialVersionUID = -2556403692023268096L;

    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "TICKET_ID", nullable = false)
    private String ticketId;

    @Column(name = "URL", nullable = true, length = 100)
    private String url;

    @Column(name = "EXTERNAL_ID", nullable = true, length = 50)
    private String externalId;

    @Column(name = "CREATED_D", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Timestamp createdDate;

    @Column(name = "TYPE", nullable = true, length = 50)
    private String type;

    @Column(name = "SUBJECT", nullable = true, length = 50)
    private String subject;

    @Column(name = "DESCRIPTION", nullable = true, length = 250)
    private String description;

    @Column(name = "PRIORITY", nullable = true, length = 20)
    private String priority;

    @Column(name = "PENDING", nullable = true, length = 20)
    private String pending;

    @Column(name = "STATUS", nullable = true, length = 50)
    private String status;

    @Column(name = "ASSIGNEE_ID", nullable = true)
    private Long assigneeId;

    @Column(name = "SUBMITTER_ID", nullable = true)
    private Long submitterId;

    @Column(name = "ORGANIZATION_ID", nullable = true)
    private Long organizationId;

    @Column(name = "HAS_INCIDENTS", columnDefinition = "TINYINT(1)", nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean hasIncidents;

    @Column(name = "VIA", nullable = true, length = 50)
    private String via;

    @Column(name = "DUE_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Timestamp dueDate;

    @Column(name = "TAGS", nullable = false, length = 100)
    private String tags;

    /**
     * Gets ticket id.
     *
     * @return the ticket id
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Sets ticket id.
     *
     * @param ticketId the ticket id
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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
     * Gets pending.
     *
     * @return the pending
     */
    public String getPending() {
        return pending;
    }

    /**
     * Sets pending.
     *
     * @param pending the pending
     */
    public void setPending(String pending) {
        this.pending = pending;
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
     * Gets assigneeId.
     *
     * @return the assigneeId
     */
    public Long getAssigneeId() {
        return assigneeId;
    }

    /**
     * Sets assigneeId.
     *
     * @param assigneeId the assigneeId
     */
    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    /**
     * Gets submitterId.
     *
     * @return the submitterId
     */
    public Long getSubmitterId() {
        return submitterId;
    }

    /**
     * Sets assigneeId.
     *
     * @param submitterId the submitterId
     */
    public void setSubmitterId(Long submitterId) {
        this.submitterId = submitterId;
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
     * Gets shared.
     *
     * @return the shared
     */
    public Boolean hasIncidents() {
        return hasIncidents;
    }

    /**
     * Sets getHasIncidents.
     *
     * @param hasIncidents the getHasIncidents boolean
     */
    public void setHasIncidents(Boolean hasIncidents) {
        this.hasIncidents = hasIncidents;
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


    /**
     * Gets last logic date.
     *
     * @return the last logic date
     */
    public Timestamp getDueDate() {
        return dueDate;
    }

    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Gets organization userId.
     *
     * @return the organization userId
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets organization userId.
     *
     * @param organizationId the organization userId
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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
}
