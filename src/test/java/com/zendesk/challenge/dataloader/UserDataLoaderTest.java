package com.zendesk.challenge.dataloader;

import com.zendesk.challenge.data.domain.jpa.User;
import com.zendesk.challenge.data.domain.repository.UserRepository;
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
 * <code>UserDataLoaderTest</code> unit test for UserDataLoader
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
    private UserRepository userRepository;

    @InjectMocks
    private UserDataLoader userDataLoader;

    /**
     * Setup the UserDataLoader unit-test.
     *
     * @throws java.lang.Exception is thrown when error occurred
     */
    @Before
    public void setUp() throws Exception {
        userDataLoader = new UserDataLoader();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUploadUserData() {
        userDataLoader.run(null);
        verify(userRepository, times(75)).save(any(User.class));
    }

}
