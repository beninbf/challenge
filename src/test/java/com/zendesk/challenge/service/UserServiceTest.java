package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setup() {
        userService = new UserServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        User user = mock(User.class);
        List<User> users = Arrays.asList(user);
        when(userRepository.getUsers(anyString(), anyLong())).thenReturn(users);
        List<User> result = userService.getUsers("userId", 1l);
        assertNotNull("users should not be null", result);
        assertFalse("users should not be empty", result.isEmpty());
        assertTrue("users size should be 1", result.size() == 1);
    }
}
