package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.service.impl.OrganizationServiceImpl;
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

public class OrganizationServiceTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @InjectMocks
    private OrganizationService organizationService;

    @Before
    public void setup() {
        organizationService = new OrganizationServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        Organization organization = mock(Organization.class);
        List<Organization> organizations = Arrays.asList(organization);
        when(organizationRepository.getOrganizations(anyString(), anyLong())).thenReturn(organizations);
        List<Organization> result = organizationService.getOrganizations("userId", 1l);
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }
}
