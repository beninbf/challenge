package com.zendesk.challenge.service;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.service.impl.OrganizationServiceImpl;
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
 * <code>OrganizationServiceImplTest</code> unit test for OrganizationService Interface
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
public class OrganizationServiceImplTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @Mock
    private BooleanValueScrubber booleanValueScrubber;

    @InjectMocks
    private OrganizationService organizationService;

    @Before
    public void setup() {
        organizationService = new OrganizationServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        Organization organization = mock(Organization.class);
        when(organizationRepository.findById(anyLong())).thenReturn(Optional.of(organization));
        Organization result = organizationService.findById(1l);
        verify(organizationRepository, times(1)).findById(anyLong());
        assertNotNull("result should not be null", result);
    }

    @Test
    public void testFindOrganizationsByField() {
        Organization organization = mock(Organization.class);
        List<Organization> organizations = Arrays.asList(organization);
        when(organizationRepository.findOrganizationsByField(anyString(), any(Object.class))).thenReturn(organizations);
        when(booleanValueScrubber.scrub(any(Set.class), anyString(), anyString())).thenReturn("test");

        List<Organization> result = organizationService.findOrganizationsByField("name", "test");

        verify(organizationRepository, times(1)).findOrganizationsByField(anyString(), any(Object.class));
        verify(booleanValueScrubber, times(1)).scrub(any(Set.class), anyString(), anyString());
        assertNotNull("result should not be null", result);
        assertFalse("result should not be empty", result.isEmpty());
        assertTrue("result size should be 1", result.size() == 1);
    }

    @Test
    public void testFindOrganizationsByField_Exception() {
        NumberFormatException nfe = mock(NumberFormatException.class);
        when(booleanValueScrubber.scrub(any(Set.class), anyString(), anyString())).thenReturn("test");
        when(organizationRepository.findOrganizationsByField(anyString(), anyLong())).thenThrow(nfe);

        List<Organization> result = organizationService.findOrganizationsByField("id", "1");

        verify(organizationRepository, times(1)).findOrganizationsByField(anyString(), any(Object.class));
        verify(booleanValueScrubber, times(1)).scrub(any(Set.class), anyString(), anyString());

        assertTrue("result should be empty", result.isEmpty());
    }

    @Test
    public void testOrgannizationSave() {
        Organization organization = GenericTestDataFactory.getOrganization();
        organizationService.save(organization);
        verify(organizationRepository, times(1)).save(any(Organization.class));
    }

    @Test
    public void testGetFields() {
        List<String> fields = organizationService.getFields();
        assertNotNull("field list should not be null", fields);
        assertTrue("field list should not be empty null", !fields.isEmpty());
    }
}
