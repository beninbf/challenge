package com.zendesk.challenge.controller;

import com.zendesk.challenge.service.OrganizationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 *
 * <code>OrganizationOptionsControllerTest</code> unit test for OrganizationOptionsController.
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
public class OrganizationOptionsControllerTest {

    @Mock
    OrganizationService organizationService;

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
    public void testOrganizationOptionsController() {
        Map<String, Object> map = new HashMap<>();
        when(organizationService.getFields()).thenReturn(Arrays.asList("field"));
        String path = organziationOptionsController.organizationOptions(map);
        assertEquals("should be organization-options", "organization-options", path);
    }
}
