package com.zendesk.challenge.data.domain.repository;

import com.zendesk.challenge.data.domain.jpa.User;
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
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
    private TestUtil testUtil;

    @Before
    public void setUp() {
        testUtil.deleteAllRepositories();
    }

    @Test
    public void testGetUsers() {
        User user = getUser();
        userRepository.save(user);
        List<User> results = userRepository.getUsers("userId", Long.valueOf(11));
        assertEquals("should be 1", 1, results.size());
        assertEquals("user_id should be 1", 11l, results.get(0).getUserId().longValue());

        List<User> externalId = userRepository.getUsers("externalId", "abc");
        assertEquals("size should be 1", 1, externalId.size());
        assertEquals("externalId should be abc", "abc", externalId.get(0).getExternalId());

        List<User> suspended = userRepository.getUsers("suspended", Boolean.TRUE);
        assertEquals("size should be 1", 1, suspended.size());
        assertEquals("suspended should be true", true, suspended.get(0).isSuspended());

        User anotherUser = getUser();
        userRepository.save(anotherUser);
        List<User> externalId1 = userRepository.getUsers("externalId", "abc");
        assertEquals("should be 2", 2, externalId1.size());

        User emptyNameUser = getUser();
        emptyNameUser.setName(null);
        emptyNameUser.setUserId(100l);
        userRepository.save(emptyNameUser);
        List<User> emptyUserList = userRepository.getUsers("name", null);
        User emptyUser = userRepository.findByUserId(100l);
        assertEquals("should be 1", 1, emptyUserList.size());
        assertEquals("should be 100", 100l, emptyUser.getUserId().longValue());
        assertEquals("subject should be 100", 100l, emptyUserList.get(0).getUserId().longValue());
    }

    private User getUser() {
        User user = new User();
        user.setUserId(11L);
        user.setUrl("Test");
        user.setExternalId("abc");
        user.setName("test name");
        user.setAlias("test alias");
        user.setCreatedDate(new Timestamp(new Date().getTime()));
        user.setActive(true);
        user.setShared(true);
        user.setVerified(true);
        user.setLastLoginDate(new Timestamp(new Date().getTime()));
        user.setEmail("test@email.com");
        user.setSignature("sig");
        user.setPhone("888-888-8888");
        user.setOrganizationId(3l);
        user.setSuspended(true);
        user.setTags(Arrays.asList("hello","ok","good"));
        user.setRole("admin");
        user.setLocale("locale");
        user.setTimezone("timezone");
        return user;
    }

    @After
    public void after() {
        testUtil.deleteAllRepositories();
    }

}
