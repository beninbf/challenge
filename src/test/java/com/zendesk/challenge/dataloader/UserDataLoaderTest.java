package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.Organization;
import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.service.OrganizationService;
import com.zendesk.challenge.service.TimeFormatter;
import com.zendesk.challenge.service.UserService;
import com.zendesk.challenge.util.GenericTestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * <code>UserDataLoaderTest</code> unit test for UserDataLoader.
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
public class UserDataLoaderTest {

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private TimeFormatter timeForamtter;

    @InjectMocks
    private UserDataLoader userDataLoader;

    @Before
    public void setUp() throws Exception {
        userDataLoader = new UserDataLoader();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadUserData() {
        Organization organization = GenericTestDataFactory.getOrganization();
        when(organizationService.findById(anyLong())).thenReturn(organization);
        userDataLoader.run(null);
        verify(userService, times(75)).save(any(User.class));
    }
}
