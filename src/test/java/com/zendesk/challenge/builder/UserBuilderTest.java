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
}
