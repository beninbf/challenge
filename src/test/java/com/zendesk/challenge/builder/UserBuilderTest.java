package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.UserModel;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserBuilderTest {

    @Test
    public void testBuild() {
        UserModel model = getUserModel();
        User user = new UserBuilder().model(model).build();
        assertNotNull("user should not be null", user);
        assertEquals("user id should be 11", model.getId().longValue(), user.getUserId().longValue());
    }

    @Test
    public void testBuildModel() {
        User user = getUser();
        UserModel model = new UserBuilder().user(user).buildModel();
        assertNotNull("user should not be null", user);
        assertEquals("user id should be 11", user.getUserId().longValue(), model.getId().longValue());
    }

    private UserModel getUserModel() {
        UserModel userModel = new UserModel();
        userModel.setId(11L);
        userModel.setUrl("Test");
        userModel.setExternalId("abc");
        userModel.setName("test name");
        userModel.setAlias("test alias");
        userModel.setCreatedAt(new Date());
        userModel.setActive(true);
        userModel.setShared(true);
        userModel.setVerified(true);
        userModel.setLastLoginDate(new Date());
        userModel.setEmail("test@email.com");
        userModel.setSignature("sig");
        userModel.setPhone("888-888-8888");
        userModel.setOrganizationId(3l);
        userModel.setSuspended(true);
        userModel.setTags(Arrays.asList("hello","ok","good"));
        userModel.setRole("admin");
        userModel.setLocale("locale");
        userModel.setTimezone("timezone");
        return userModel;
    }

    private User getUser() {
        User user = new User();
        user.setUserId(11L);
        user.setUrl("Test");
        user.setExternalId("abc");
        user.setName("test name");
        user.setAlias("test alias");
        user.setCreatedDate(new Timestamp(new Date().getTime()));
        user.setActive(true);
        user.setShared(true);
        user.setVerified(true);
        user.setLastLoginDate(new Timestamp(new Date().getTime()));
        user.setEmail("test@email.com");
        user.setSignature("sig");
        user.setPhone("888-888-8888");
        user.setOrganizationId(3l);
        user.setSuspended(true);
        user.setTags(Arrays.asList("hello","ok","good"));
        user.setRole("admin");
        user.setLocale("locale");
        user.setTimezone("timezone");
        return user;
    }
}
