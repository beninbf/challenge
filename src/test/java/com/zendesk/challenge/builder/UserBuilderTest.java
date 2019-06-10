package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 *
 * <code>UserBuilderTest</code> unit test for Userbuilder
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
public class UserBuilderTest {

    @Mock
    private TimeFormatter timeFormatter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(timeFormatter.getDateFromString(anyString())).thenReturn(new Timestamp(new Date().getTime()));
        when(timeFormatter.getStringFromTimeStamp(any(Timestamp.class))).thenReturn(new Date().toString());
    }

    @Test
    public void testBuild() {
        UserModel model = GenericTestDataFactory.getUserModel();
        Organization organization = GenericTestDataFactory.getOrganization();
        User user = new UserBuilder().model(model).organization(organization).timeFormatter(timeFormatter).build();
        assertNotNull("user should not be null", user);
        assertEquals("user id should be 11", model.getId().longValue(), user.getId().longValue());
        assertNotNull("url should not be null", user.getUrl());
        assertNotNull("externalId should not be null", user.getExternalId());
        assertNotNull("name should not be null", user.getName());
        assertNotNull("isActive should not be null", user.isActive());
        assertNotNull("isShared should not be null", user.isShared());
        assertNotNull("isVerified should not be null", user.isVerified());
        assertNotNull("isSuspended should not be null", user.isSuspended());
        assertNotNull("lastLoginDate should not be null", user.getLastLoginDate());
        assertNotNull("local should not be null", user.getLocale());
        assertNotNull("timezone should not be null", user.getTimezone());
        assertNotNull("tags should not be null", user.getTags());
        assertNotNull("organization id should not be null", user.getOrganization().getId());
        assertNotNull("role should not be null", user.getRole());
    }

    @Test
    public void testBuildModel() {
        User user = GenericTestDataFactory.getUser(4l);
        UserModel model = new UserBuilder().user(user).organization(user.getOrganization()).timeFormatter(timeFormatter).buildModel();
        assertNotNull("user should not be null", user);
        assertEquals("user id should be 11", user.getId().longValue(), model.getId().longValue());
        assertNotNull("url should not be null", model.getUrl());
        assertNotNull("external should not be null", model.getExternalId());
        assertNotNull("name should not be null", model.getName());
        assertNotNull("active should not be null", model.getActive());
        assertNotNull("shared should not be null", model.getShared());
        assertNotNull("verified should not be null", model.getVerified());
        assertNotNull("suspeneded should not be null", model.getSuspended());
        assertNotNull("lastLoginAt should not be null", model.getLastLoginAt());
        assertNotNull("locale should not be null", model.getLocale());
        assertNotNull("timezone should not be null", model.getTimezone());
        assertNotNull("tage should not be null", model.getTags());
        assertNotNull("organizatoinId should not be null", model.getOrganizationId());
        assertNotNull("role should not be null", model.getRole());
    }
}
