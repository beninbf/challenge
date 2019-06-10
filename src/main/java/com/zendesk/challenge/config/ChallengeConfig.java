package com.zendesk.challenge.config;

import com.zendesk.challenge.service.BooleanValueScrubber;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TicketService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
import com.zendesk.challenge.service.impl.BooleanValueScrubberImpl;
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
 *
 * <code>ChallengeConfig</code> Spring Config class for generating service beans.
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

    @Bean
    public BooleanValueScrubber booleanValueScrubber() {
        return new BooleanValueScrubberImpl();
    }

    @Bean
    public TimeFormatter timeFormatter() {
        return new TimeFormatter();
    }
}
