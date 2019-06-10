package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * <code>OrganizationDataLoaderTest</code> unit test for OrganizationDataLoader
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
public class OrganizationDataLoaderTest {

    @Mock
    private OrganizationService organizationService;

    @Mock
    private TimeFormatter timeForamtter;

    @InjectMocks
    private OrganizationDataLoader organizationDataLoader;

    /**
     * Setup the UserDataLoader unit-test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        organizationDataLoader = new OrganizationDataLoader();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadOrganizationData() {
        organizationDataLoader.run(null);
        verify(organizationService, times(26)).save(any(Organization.class));
    }

}
