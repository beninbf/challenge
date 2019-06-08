package com.zendesk.challenge.config;

import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChallengeConfigTest {

    private ChallengeConfig config;

    /**
     * Setup the ChallengeConfig unit-test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        config = new ChallengeConfig();
    }

    /**
     * Test method for {@link com.zendesk.challenge.config.ChallengeConfig#userService()}.
     */
    @Test
    public void testUserService() {
        assertNotNull(config.userService());
        assertTrue(config.userService() instanceof UserService);
    }

    /**
     * Test method for {@link com.zendesk.challenge.config.ChallengeConfig#ticketService()}.
     */
    @Test
    public void testTicketService() {
        assertNotNull(config.ticketService());
        assertTrue(config.ticketService() instanceof TicketService);
    }

    /**
     * Test method for {@link ChallengeConfig#organizationService()}.
     */
    @Test
    public void testOrganizationService() {
        assertNotNull(config.organizationService());
        assertTrue(config.organizationService() instanceof OrganizationService);
    }
}
