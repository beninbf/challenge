package com.zendesk.challenge.data.domain.jpa;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 *
 * <code>User</code> class is a database entity mapping to table USER.
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
public class User implements Serializable {

    private static final long serialVersionUID = -2556403692023268096L;

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "URL", nullable = true, length = 100)
    private String url;

    @Column(name = "EXTERNAL_ID", nullable = true, length = 50)
    private String externalId;

    @Column(name = "NAME", nullable = true, length = 50)
    private String name;

    @Column(name = "ALIAS", nullable = true, length = 50)
    private String alias;

    @Column(name = "CREATED_D", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Timestamp createdDate;

    @Column(name = "ACTIVE", columnDefinition = "TINYINT(1)", nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;

    @Column(name = "VERIFIED", columnDefinition = "TINYINT(1)", nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean verified;

    @Column(name = "SHARED", columnDefinition = "TINYINT(1)", nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean shared;

    @Column(name = "LOCALE", nullable = true, length = 20)
    private String locale;

    @Column(name = "TIMEZONE", nullable = true, length = 50)
    private String timezone;

    @Column(name = "LAST_LOGIN_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Timestamp lastLoginDate;

    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;

    @Column(name = "PHONE", nullable = true, length = 20)
    private String phone;

    @Column(name = "SIGNATURE", nullable = true, length = 50)
    private String signature;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID", nullable = true)
    private Organization organization;

    @Column(name = "TAGS", nullable = false, length = 100)
    private String tags;

    @Column(name = "SUSPENDED", columnDefinition = "TINYINT(1)", nullable = true)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean suspended;

    @Column(name = "ROLE", nullable = false, length = 20)
    private String role;

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
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
     * Gets alias.
     *
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets alias.
     *
     * @param alias the alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
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
     * Gets active.
     *
     * @return the active
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Gets verified.
     *
     * @return the verified
     */
    public Boolean isVerified() {
        return verified;
    }

    /**
     * Sets verified.
     *
     * @param verified the verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * Gets shared.
     *
     * @return the shared
     */
    public Boolean isShared() {
        return shared;
    }

    /**
     * Sets shared.
     *
     * @param shared the shared
     */
    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    /**
     * Gets locale.
     *
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets locale.
     *
     * @param locale the locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Gets timezone.
     *
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * Gets last logic date.
     *
     * @return the last logic date
     */
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * Sets last logic date.
     *
     * @param lastLoginDate the last logic date
     */
    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets signature.
     *
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets signature.
     *
     * @param signature the signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Gets organization id.
     *
     * @return the organization id
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Sets organization id.
     *
     * @param organization the organization id
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
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
     * Gets suspended.
     *
     * @return the suspended
     */
    public Boolean isSuspended() {
        return suspended;
    }

    /**
     * Sets suspended.
     *
     * @param suspended the suspended
     */
    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
