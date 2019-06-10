package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.User;
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
 * <code>UserRepositoryImplTest</code> unit test for UserRepositoryImpl
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
public class UserRepositoryImplTest {

    @Inject
    UserRepository userRepository;

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
        User user = GenericTestDataFactory.getUser(1l);
        organizationRepository.save(user.getOrganization());
        userRepository.save(user);
        Optional<User> findByIdUser = userRepository.findById(1l);
        assertEquals("user id should be 1", 1l, findByIdUser.get().getId().longValue());
    }

    @Test
    public void testFindUsersByField() {
        User user = GenericTestDataFactory.getUser(1l);
        organizationRepository.save(user.getOrganization());
        userRepository.save(user);
        List<User> results = userRepository.findUsersByField("id", Long.valueOf(1));
        Optional<User> findByIdUser = userRepository.findById(1l);
        assertEquals("should be 1", 1, results.size());
        assertEquals("user_id should be 1", 1l, results.get(0).getId().longValue());
        assertEquals("user id should be 1", 1l, findByIdUser.get().getId().longValue());

        List<User> externalId = userRepository.findUsersByField("externalId", "abc");
        assertEquals("size should be 1", 1, externalId.size());
        assertEquals("externalId should be abc", "abc", externalId.get(0).getExternalId());

        List<User> suspended = userRepository.findUsersByField("suspended", Boolean.TRUE);
        assertEquals("size should be 1", 1, suspended.size());
        assertEquals("suspended should be true", true, suspended.get(0).isSuspended());
        assertEquals("organization id should be", 5l, suspended.get(0).getOrganization().getId().longValue());

        User anotherUser = GenericTestDataFactory.getUser(2l);
        userRepository.save(anotherUser);
        List<User> externalId1 = userRepository.findUsersByField("externalId", "abc");
        assertEquals("should be 2", 2, externalId1.size());

        User emptyNameUser = GenericTestDataFactory.getUser(3l);
        emptyNameUser.setName(null);
        emptyNameUser.setId(100l);
        userRepository.save(emptyNameUser);
        List<User> emptyUserList = userRepository.findUsersByField("name", null);
        Optional<User> emptyUser = userRepository.findById(100l);
        assertEquals("should be 1", 1, emptyUserList.size());
        assertEquals("should be 100", 100l, emptyUser.get().getId().longValue());
        assertEquals("subject should be 100", 100l, emptyUserList.get(0).getId().longValue());
        assertEquals("user id with empty name should be 100", 100l, emptyUser.get().getId().longValue());
    }

    @Test
    public void testSave() {
        User user = GenericTestDataFactory.getUser(1000l);
        organizationRepository.save(user.getOrganization());
        User result = userRepository.save(user);
        assertNotNull("result should not be null", result);
        assertEquals("result id should not be 1000", user.getId(), result.getId());
    }

    @After
    public void after() {
        testUtil.deleteAllRepositories();
    }
}
