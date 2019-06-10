package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.model.UserModel;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    }

    @Test
    public void testBuild() {
        UserModel model = GenericTestDataFactory.getUserModel();
        User user = new UserBuilder().model(model).timeFormatter(timeFormatter).build();
        assertNotNull("user should not be null", user);
        assertEquals("user id should be 11", model.getId().longValue(), user.getId().longValue());
    }

    @Test
    public void testBuildModel() {
        User user = GenericTestDataFactory.getUser(4l);
        UserModel model = new UserBuilder().user(user).timeFormatter(timeFormatter).buildModel();
        assertNotNull("user should not be null", user);
        assertEquals("user id should be 11", user.getId().longValue(), model.getId().longValue());
    }
}
