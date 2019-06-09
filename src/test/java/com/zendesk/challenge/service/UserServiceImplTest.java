package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.service.impl.UserServiceImpl;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Mock
    private OrganizationService organizationService;

    @Mock
    private BooleanValueScrubber booleanValueScrubber;

    @InjectMocks
    private UserService userService;

    @Before
    public void setup() {
        userService = new UserServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        User user = mock(User.class);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        User result = userService.findById(1l);
        verify(userRepository, times(1)).findById(anyLong());
        assertNotNull("result should not be null", result);
    }

    @Test
    public void testFindUsersByField() {
        User user = mock(User.class);
        List<User> users = Arrays.asList(user);
        when(userRepository.findUsersByField(anyString(), anyLong())).thenReturn(users);
        List<User> result = userService.findUsersByField("userId", 1l);
        assertNotNull("users should not be null", result);
        assertFalse("users should not be empty", result.isEmpty());
        assertTrue("users size should be 1", result.size() == 1);
    }

    @Test
    public void testFindUsersByField_Exception() throws Exception {
        NumberFormatException nfe = mock(NumberFormatException.class);
        when(userRepository.findUsersByField(anyString(), anyLong())).thenThrow(nfe);
        List<User> result = userService.findUsersByField("organizationId", "1");
        verify(userRepository, times(1)).findUsersByField(anyString(), any(Object.class));
        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testFindUsers_ByOrganization() {
        User user = GenericTestDataFactory.getUser(1l);
        List<User> users = Arrays.asList(user);
        when(organizationService.findById(anyLong())).thenReturn(GenericTestDataFactory.getOrganization());
        when(userRepository.findByOrganization(any(Organization.class))).thenReturn(users);

        List<User> result = userService.findUsers("organization", "3");

        verify(userRepository, times(1)).findByOrganization(any(Organization.class));
        verify(organizationService, times(1)).findById(anyLong());
        assertNotNull("users should not be null", result);
        assertFalse("users should not be empty", result.isEmpty());
        assertTrue("users size should be 1", result.size() == 1);
    }

    @Test
    public void testFindUsers_ByNonOrganizationField() {
        User user = GenericTestDataFactory.getUser(1l);
        List<User> users = Arrays.asList(user);
        when(booleanValueScrubber.scrub(any(Set.class), anyString(), anyString())).thenReturn(Object.class);
        when(userRepository.findUsersByField(anyString(), any(Object.class))).thenReturn(users);

        List<User> result = userService.findUsers("active", "true");

        verify(userRepository, times(1)).findUsersByField(anyString(), any(Object.class));
        verify(booleanValueScrubber, times(1)).scrub(any(Set.class), anyString(), anyString());
        assertNotNull("users should not be null", result);
        assertFalse("users should not be empty", result.isEmpty());
        assertTrue("users size should be 1", result.size() == 1);
    }

    @Test
    public void testUserSave() {
        User user = GenericTestDataFactory.getUser(1l);
        userService.save(user);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testGetFields() {
        List<String> fields = userService.getFields();
        assertNotNull("field list should not be null", fields);
        assertTrue("field list should not be empty null", !fields.isEmpty());
    }
}
