package com.zendesk.challenge.util;

import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.data.domain.repository.TicketRepository;
import com.zendesk.challenge.data.domain.repository.UserRepository;
import com.zendesk.challenge.data.domain.repository.config.RepositoryTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

/**
 *
 * <code>TestUtil</code> a bean for conveniently deleting all repositories before an after tests
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
public class TestUtil {

    @Inject
    private UserRepository userRepository;

    @Inject
    private TicketRepository ticketRepository;

    @Inject
    private OrganizationRepository organizationRepository;

    public void deleteAllRepositories() {
        ticketRepository.deleteAll();
        userRepository.deleteAll();
        organizationRepository.deleteAll();
    }
}
