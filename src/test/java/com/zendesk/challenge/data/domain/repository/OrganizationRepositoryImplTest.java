package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.config.RepositoryTestConfig;
import com.zendesk.challenge.util.GenericTestDataFactory;
import com.zendesk.challenge.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * <code>OrganizationRepositoryImplTest</code> unit test for OrganizationRepository
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
    public void testFindById() {
        Organization organization = GenericTestDataFactory.getOrganization();
        organizationRepository.save(organization);
        Optional<Organization> test = organizationRepository.findById(5l);
        assertEquals("organization_id should be 5", 5l, test.get().getId().longValue());
    }

    @Test
    public void testFindOrganizationsByField() {
        Organization organization = GenericTestDataFactory.getOrganization();
        organizationRepository.save(organization);
        List<Organization> results = organizationRepository.findOrganizationsByField("id", Long.valueOf(5));
        Optional<Organization> test = organizationRepository.findById(5l);

        assertEquals("size should be 1", 1, results.size());
        assertEquals("organization_id should be 5", 5l, results.get(0).getId().longValue());
        assertEquals("organization_id should be 5", 5l, test.get().getId().longValue());

        List<Organization> names = organizationRepository.findOrganizationsByField("name", "name");
        assertEquals("size should be 1", 1, names.size());
        assertEquals("name should be name", "name", names.get(0).getName());

        Organization anotherOrganization = GenericTestDataFactory.getOrganization();
        anotherOrganization.setId(4l);
        organizationRepository.save(anotherOrganization);
        List<Organization> externalId = organizationRepository.findOrganizationsByField("externalId", "abc");
        assertEquals("should be 2", 2, externalId.size());

        Organization emptyNameOrg = GenericTestDataFactory.getOrganization();
        emptyNameOrg.setName(null);
        emptyNameOrg.setId(100l);
        organizationRepository.save(emptyNameOrg);
        List<Organization> emptyNameOrgList = organizationRepository.findOrganizationsByField("name", null);
        Optional<Organization> emptyNameOrgResult = organizationRepository.findById(100l);
        assertEquals("should be 1", 1, emptyNameOrgList.size());
        assertEquals("organization id should be 100", 100l, emptyNameOrgResult.get().getId().longValue());
        assertEquals("organization id should be 100", 100l, emptyNameOrgList.get(0).getId().longValue());
    }

    @Test
    public void testSave() {
        Organization organization = GenericTestDataFactory.getOrganization();
        Organization result = organizationRepository.save(organization);
        assertNotNull("result should not be null", result);
        assertEquals("Id should be the same", organization.getId(), result.getId());
    }

    @After
    public void after() {
        testUtil.deleteAllRepositories();
    }
}
