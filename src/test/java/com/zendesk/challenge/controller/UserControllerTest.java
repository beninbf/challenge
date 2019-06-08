package com.zendesk.challenge.controller;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    /**
     * Setup the User Controller test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        userController = new UserController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUser() {
        Map<String, Object> modelMap = new HashMap<>();
        User user = mock(User.class);
        when(userService.getUsers(anyString(), any(Object.class))).thenReturn(Arrays.asList(user));
        String path = userController.user("id", "100l", modelMap);
        assertEquals("should be user", "user", path);
        verify(userService, times(1)).getUsers(anyString(), any(Object.class));
    }
}
