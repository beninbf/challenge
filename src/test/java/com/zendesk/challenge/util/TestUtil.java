package com.zendesk.challenge.util;

import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.data.domain.repository.config.RepositoryTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryTestConfig.class)
public class TestUtil {

    @Inject
    private UserRepository userRepository;

    @Inject
    private TicketRepository ticketRepository;

    @Inject
    private OrganizationRepository organizationRepository;

    public void deleteAllRepositories() {
        userRepository.deleteAll();
        ticketRepository.deleteAll();
        organizationRepository.deleteAll();
    }
}
