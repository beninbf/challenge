package com.zendesk.challenge.controller;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>OrganizationControllerTest</code> unit test for OrganizationController.
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
public class OrganizationControllerTest {

    @Mock
    private OrganizationService organizationService;

    @Mock
    private TimeFormatter timeFormatter;

    @InjectMocks
    private OrganizationController organizationController;

    /**
     * Setup the UserDataLoader unit-test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        organizationController = new OrganizationController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOrganization() {
        Map<String, Object> modelMap = new HashMap<>();
        Organization organization = mock(Organization.class);
        when(organizationService.findOrganizationsByField(anyString(), anyString())).thenReturn(Arrays.asList(organization));
        String path = organizationController.organization("id", "100l", modelMap);
        assertEquals("should be organization", "organization", path);
        verify(organizationService, times(1)).findOrganizationsByField(anyString(), anyString());
    }
}
