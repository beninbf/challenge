package com.zendesk.challenge.data.domain.repository.config;

import com.zendesk.challenge.config.ChallengeDomainConfig;
import com.zendesk.challenge.util.TestUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@Import(ChallengeDomainConfig.class)
public class RepositoryTestConfig {

    @Bean
    public static TestUtil testUtil() {
        return new TestUtil();
    }

    /**
     * Creates a PropertySourcesPlaceholderConfigurer bean.
     *
     * @return PropertySourcesPlaceholderConfigurer bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
        config.setLocations(new Resource[] { new ClassPathResource("application.properties") });
        return config;
    }

}
