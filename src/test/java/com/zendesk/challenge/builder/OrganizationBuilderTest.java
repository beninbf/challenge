package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * <code>OrganizationBuilderTest</code> unit test for OrganizationBuilder
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
public class OrganizationBuilderTest {

    @Mock
    private TimeFormatter timeFormatter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuild() {
        OrganizationModel model = GenericTestDataFactory.getOrganizationModel();
        Organization organization  = new OrganizationBuilder().model(model).timeFormatter(timeFormatter).build();
        assertNotNull("organization should not be null", organization);
        assertEquals("organization id should be 11", model.getId(), organization.getId());
        assertNotNull("organization url not be null", organization.getUrl());
        assertNotNull("organization externalId not be null", organization.getExternalId());
        assertNotNull("organization name not be null", organization.getName());
        assertNotNull("organization domainNames not be null", organization.getDomainNames());
        assertNotNull("organization details not be null", organization.getDetails());
        assertNotNull("organization sharedTickets not be null", organization.isSharedTickets());
        assertNotNull("organization tage not be null", organization.getTags());
    }

    @Test
    public void testBuildModel() {
        Organization organization = GenericTestDataFactory.getOrganization();
        OrganizationModel model  = new OrganizationBuilder().organization(organization).timeFormatter(timeFormatter).buildModel();
        assertNotNull("organization model should not be null", organization);
        assertEquals("organization model id should be 11", 5l, model.getId().longValue());
        assertNotNull("organization url should not be null", model.getUrl());
        assertNotNull("organization url not be null", model.getUrl());
        assertNotNull("organization externalId not be null", model.getExternalId());
        assertNotNull("organization name not be null", model.getName());
        assertNotNull("organization domainNames not be null", model.getDomainNames());
        assertNotNull("organization details not be null", model.getDetails());
        assertNotNull("organization sharedTickets not be null", model.getSharedTickets());
        assertNotNull("organization tage not be null", model.getTags());

    }
}
