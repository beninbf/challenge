package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>UserServiceImplTest</code> unit test for UserService Interface
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
public class UserServiceImplTest {

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

    @Test
    public void testGetUsers_Exception() throws Exception {
        NumberFormatException nfe = mock(NumberFormatException.class);
        when(userRepository.getUsers(anyString(), anyLong())).thenThrow(nfe);
        List<User> result = userService.getUsers("organizationId", "1");
        verify(userRepository, times(1)).getUsers(anyString(), any(Object.class));
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testField() {
        User user = new User();

        Field[] fields = user.getClass().getDeclaredFields();

        for(Field field: fields) {
            System.out.println(field.getName());
        }
    }

}
