package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.TimeFormatter;

import java.sql.Timestamp;

/**
 *
 * <code>UserBuilder</code> Builder class for building User JPA objects and User Models
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
public class UserBuilder {

    private UserModel model;

    private Organization organization;

    private User user;

    private TimeFormatter timeFormatter;

    public UserBuilder model(UserModel model) {
        this.model = model;
        return this;
    }

    public UserBuilder user(User user) {
        this.user = user;
        return this;
    }

    public UserBuilder organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public UserBuilder timeFormatter(TimeFormatter timeFormatter) {
        this.timeFormatter = timeFormatter;
        return this;
    }

    public User build() {
        if (model != null && timeFormatter != null) {
            User user = new User();
            user.setId(model.getId());
            user.setUrl(model.getUrl());
            user.setExternalId(model.getExternalId());
            user.setName(model.getName());
            user.setAlias(model.getAlias());
            if (model.getCreatedAt() != null) {
                user.setCreatedDate(timeFormatter.getDateFromString(model.getCreatedAt()));
            }
            user.setActive(model.getActive());
            user.setShared(model.getShared());
            user.setVerified(model.getVerified());
            if (model.getLastLoginAt() != null) {
                user.setLastLoginDate(timeFormatter.getDateFromString(model.getLastLoginAt()));
            }
            user.setEmail(model.getEmail());
            user.setSignature(model.getSignature());
            user.setPhone(model.getPhone());
            user.setOrganization(organization);
            user.setSuspended(model.getSuspended());
            user.setTags(model.getTags());
            user.setRole(model.getRole());
            user.setLocale(model.getLocale());
            user.setTimezone(model.getTimezone());
            return user;
        } else {
            throw new IllegalArgumentException("UserModel and TimeFormatter must be set to create a user db object");
        }
    }

    public UserModel buildModel() {
        if (user != null && timeFormatter != null) {
            UserModel userModel = new UserModel();
            userModel.setId(user.getId());
            userModel.setUrl(user.getUrl());
            userModel.setExternalId(user.getExternalId());
            userModel.setName(user.getName());
            userModel.setAlias(user.getAlias());
            if (user.getCreatedDate() != null) {
                userModel.setCreatedAt(timeFormatter.getStringFromTimeStamp(user.getCreatedDate()));

            }
            userModel.setActive(user.isActive());
            userModel.setShared(user.isShared());
            userModel.setVerified(user.isVerified());
            if (user.getLastLoginDate() != null) {
                userModel.setLastLoginDate(timeFormatter.getStringFromTimeStamp(user.getLastLoginDate()));
            }
            userModel.setEmail(user.getEmail());
            userModel.setSignature(user.getSignature());
            userModel.setPhone(user.getPhone());
            if (organization != null) {
                userModel.setOrganizationId(organization.getId());
            }
            userModel.setSuspended(user.isSuspended());
            userModel.setTags(user.getTags());
            userModel.setRole(user.getRole());
            userModel.setLocale(user.getLocale());
            userModel.setTimezone(user.getTimezone());
            return userModel;
        } else {
            throw new IllegalArgumentException("User and TimeFormatter and Organization must be set to create a UserModel object");
        }
    }
}
