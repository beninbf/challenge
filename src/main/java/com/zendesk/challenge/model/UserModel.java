package com.zendesk.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * <code>UserModel</code> model object for users.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class UserModel implements Serializable {

    private static final long serialVersionUID = -1702280467535730161L;

    @JsonProperty("_id")
    private Long id;

    private String url;

    @JsonProperty("external_id")
    private String externalId;

    private String name;

    private String alias;

    @JsonProperty("created_at")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt;

    private Boolean active;

    private Boolean verified;

    private Boolean shared;

    private String locale;

    private String timezone;

    @JsonProperty("last_login_at")
    @JsonDeserialize(using = DateDeserializer.class)
    private Date lastLoginAt;

    private String email;

    private String phone;

    private String signature;

    @JsonProperty("organization_id")
    private Long organizationId;

    private List<String> tags;

    private Boolean suspended;

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
     * Gets active.
     *
     * @return the active
     */
    public Boolean getActive() {
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
    public Boolean getVerified() {
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
    public Boolean getShared() {
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
    public Date getLastLoginAt() {
        return lastLoginAt;
    }


    /**
     * Sets last login date.
     *
     * @param lastLoginDate the last login date
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginAt = lastLoginDate;
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
    public Boolean getSuspended() {
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
