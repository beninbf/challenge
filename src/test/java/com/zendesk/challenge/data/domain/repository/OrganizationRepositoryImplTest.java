package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.config.RepositoryTestConfig;
import com.zendesk.challenge.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrganizationRepositoryImplTest {

    @Inject
    OrganizationRepository organizationRepository;

    @Inject
    private TestUtil testUtil;

    @Before
    public void setUp() {
        testUtil.deleteAllRepositories();
    }

    @Test
    public void testGetOrganizations() {
        Organization ticket = getOrganization();
        organizationRepository.save(ticket);
        List<Organization> results = organizationRepository.getOrganizations("organizationId", Long.valueOf(5));
        Organization test = organizationRepository.findByOrganizationId(5l);

        assertEquals("size should be 1", 1, results.size());
        assertEquals("organization_id should be 5", 5l, results.get(0).getOrgnizationId().longValue());
        assertEquals("organization_id should be 5", 5l, test.getOrgnizationId().longValue());

        List<Organization> names = organizationRepository.getOrganizations("name", "name");
        assertEquals("size should be 1", 1, names.size());
        assertEquals("name should be name", "name", names.get(0).getName());

        Organization anotherOrganization = getOrganization();
        organizationRepository.save(anotherOrganization);
        List<Organization> externalId = organizationRepository.getOrganizations("externalId", "abc");
        assertEquals("should be 2", 2, externalId.size());

        Organization emptyNameOrg = getOrganization();
        emptyNameOrg.setName(null);
        emptyNameOrg.setOrganizationId(100l);
        organizationRepository.save(emptyNameOrg);
        List<Organization> emptyOrgList = organizationRepository.getOrganizations("name", null);
        Organization emptyOrg = organizationRepository.findByOrganizationId(100l);
        assertEquals("should be 1", 1, emptyOrgList.size());
        assertEquals("should be 100", 100l, emptyOrg.getOrgnizationId().longValue());
        assertEquals("subject should be 100", 100l, emptyOrgList.get(0).getOrgnizationId().longValue());
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


    @After
    public void after() {
        testUtil.deleteAllRepositories();
    }
}
