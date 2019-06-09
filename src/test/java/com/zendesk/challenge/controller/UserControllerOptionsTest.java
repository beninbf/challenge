package com.zendesk.challenge.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserControllerOptionsTest {

    @InjectMocks
    private UserOptionsController userOptionsController;

    /**
     * Setup the User Options Controller test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        userOptionsController = new UserOptionsController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUserOptionsController() {
        Map<String, Object> map = new HashMap<>();
        String path = userOptionsController.userOptions(map);
        assertEquals("should be user-options", "user-options", path);
    }
}
