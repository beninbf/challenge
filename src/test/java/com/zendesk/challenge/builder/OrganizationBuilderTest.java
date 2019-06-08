package com.zendesk.challenge.builder;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.model.OrganizationModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrganizationBuilderTest {

    @Test
    public void testBuild() {
        OrganizationModel model = getOrganizationModel();
        Organization organization  = new OrganizationBuilder().model(model).build();
        assertNotNull("organization should not be null", organization);
        assertEquals("organization id should be 11", model.getId(), organization.getOrgnizationId());
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
}
