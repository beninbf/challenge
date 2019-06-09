package com.zendesk.challenge.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class OrganizationOptionsControllerTest {

    @InjectMocks
    private OrganizationOptionsController organziationOptionsController;

    /**
     * Setup the Organization Options Controller test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        organziationOptionsController = new OrganizationOptionsController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUser() {
        String path = organziationOptionsController.organizationOptions();
        assertEquals("should be organization-options", "organization-options", path);
    }
}
