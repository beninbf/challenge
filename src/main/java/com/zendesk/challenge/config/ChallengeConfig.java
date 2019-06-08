package com.zendesk.challenge.config;

import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.UserService;
import com.zendesk.challenge.service.impl.OrganizationServiceImpl;
import com.zendesk.challenge.service.impl.TicketServiceImpl;
import com.zendesk.challenge.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Challenge Config - Spring Config class for generating beans.
 */
@Configuration
@ComponentScan(basePackages = { "com.zendesk.challenge.service", "com.zendesk.challenge.controller"})
@Import({ChallengeDomainConfig.class})
public class ChallengeConfig {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeConfig.class);

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public TicketService ticketService() {
        return new TicketServiceImpl();
    }

    @Bean
    public OrganizationService organizationService() {
        return new OrganizationServiceImpl();
    }

}
