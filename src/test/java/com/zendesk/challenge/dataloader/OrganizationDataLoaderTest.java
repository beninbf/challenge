package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.repository.OrganizationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OrganizationDataLoaderTest {

    @Mock
    private OrganizationRepository organizationRepository;

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
        verify(organizationRepository, times(26)).save(any(Organization.class));
    }

}
