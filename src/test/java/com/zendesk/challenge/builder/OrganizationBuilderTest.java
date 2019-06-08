package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

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

    @Test
    public void testBuild() {
        OrganizationModel model = getOrganizationModel();
        Organization organization  = new OrganizationBuilder().model(model).build();
        assertNotNull("organization should not be null", organization);
        assertEquals("organization id should be 11", model.getId(), organization.getOrgnizationId());
    }

    @Test
    public void testBuildModel() {
        Organization organization = getOrganization();
        OrganizationModel model  = new OrganizationBuilder().organization(organization).buildModel();
        assertNotNull("organization model should not be null", organization);
        assertEquals("organization model id should be 11", 5l, model.getId().longValue());
    }

    private OrganizationModel getOrganizationModel() {
        OrganizationModel organizationModel = new OrganizationModel();
        organizationModel.setId(5l);
        organizationModel.setUrl("Test");
        organizationModel.setName("name");
        organizationModel.setExternalId("abc");
        organizationModel.setCreatedAt(new Date());
        organizationModel.setDetails("test details");
        organizationModel.setSharedTickets(true);
        organizationModel.setTags(Arrays.asList("blah,blah,blah"));
        organizationModel.setDomainNames(Arrays.asList("domain.com,blah.com,blah.com"));
        return organizationModel;
    }

    private Organization getOrganization() {
        Organization organization = new Organization();
        organization.setOrganizationId(5l);
        organization.setUrl("Test");
        organization.setName("name");
        organization.setExternalId("abc");
        organization.setCreatedDate(new Timestamp(new Date().getTime()));
        organization.setDetails("test details");
        organization.setSharedTickets(true);
        organization.setTags(Arrays.asList("blah,blah,blah"));
        organization.setDomainNames(Arrays.asList("domain.com,blah.com,blah.com"));
        return organization;
    }
}
