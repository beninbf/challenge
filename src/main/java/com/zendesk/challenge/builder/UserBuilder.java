package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.UserModel;

import java.sql.Timestamp;

public class UserBuilder {

    private UserModel model;

    private User user;

    public UserBuilder model(UserModel model) {
        this.model = model;
        return this;
    }


    public UserBuilder user(User user) {
        this.user = user;
        return this;
    }

    public User build() {
        if (model != null) {
            User user = new User();
            user.setUserId(model.getId());
            user.setUrl(model.getUrl());
            user.setExternalId(model.getExternalId());
            user.setName(model.getName());
            user.setAlias(model.getAlias());
            if (model.getCreatedAt() != null) {
                user.setCreatedDate(new Timestamp(model.getCreatedAt().getTime()));
            }
            user.setActive(model.getActive());
            user.setShared(model.getShared());
            user.setVerified(model.getVerified());
            if (model.getLastLoginAt() != null) {
                user.setLastLoginDate(new Timestamp(model.getLastLoginAt().getTime()));
            }
            user.setEmail(model.getEmail());
            user.setSignature(model.getSignature());
            user.setPhone(model.getPhone());
            user.setOrganizationId(model.getOrganizationId());
            user.setSuspended(model.getSuspended());
            user.setTags(model.getTags());
            user.setRole(model.getRole());
            user.setLocale(model.getLocale());
            user.setTimezone(model.getTimezone());
            return user;
        } else {
            throw new IllegalArgumentException("UserModel must be set to create a user db object");
        }
    }

    public UserModel buildModel() {
        if (user != null) {
            UserModel userModel = new UserModel();
            userModel.setId(user.getUserId());
            userModel.setUrl(user.getUrl());
            userModel.setExternalId(user.getExternalId());
            userModel.setName(user.getName());
            userModel.setAlias(user.getAlias());
            if (user.getCreatedDate() != null) {
                user.setCreatedDate(new Timestamp(user.getCreatedDate().getTime()));
            }
            userModel.setActive(user.isActive());
            userModel.setShared(user.isShared());
            userModel.setVerified(user.isVerified());
            if (user.getLastLoginDate() != null) {
                userModel.setLastLoginDate(new Timestamp(user.getLastLoginDate().getTime()));
            }
            userModel.setEmail(user.getEmail());
            userModel.setSignature(user.getSignature());
            userModel.setPhone(user.getPhone());
            userModel.setOrganizationId(user.getOrganizationId());
            userModel.setSuspended(user.isSuspended());
            userModel.setTags(user.getTags());
            userModel.setRole(user.getRole());
            userModel.setLocale(user.getLocale());
            userModel.setTimezone(user.getTimezone());
            return userModel;
        } else {
            throw new IllegalArgumentException("UserModel must be set to create a user db object");
        }
    }
}
