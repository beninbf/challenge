package com.zendesk.challenge.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

/**
 *
 * <code>ChallengeDomainConfig</code>  Configuration class for jpa and repository objects.
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
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories("com.zendesk.challenge.data.domain.repository")
@EntityScan("com.zendesk.challenge.data.domain.jpa")
public class ChallengeDomainConfig {

    private static final Logger logger = LoggerFactory.getLogger(ChallengeDomainConfig.class);

    /**
     * Executes spring post construct process.
     */
    @PostConstruct
    public void postConstruct() {
        logger.info("Enabled JPA repositories for basePackages=com.zendesk.challenge.data.domain.repository");
    }
}
