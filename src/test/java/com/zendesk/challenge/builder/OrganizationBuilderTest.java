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
    }

    @Test
    public void testBuildModel() {
        Organization organization = GenericTestDataFactory.getOrganization();
        OrganizationModel model  = new OrganizationBuilder().organization(organization).timeFormatter(timeFormatter).buildModel();
        assertNotNull("organization model should not be null", organization);
        assertEquals("organization model id should be 11", 5l, model.getId().longValue());
    }
}
