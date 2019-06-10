package com.zendesk.challenge.service;

import com.zendesk.challenge.service.impl.BooleanValueScrubberImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * <code>BooleanValueScrubberTest</code> unit test for the BooleanValueScrubberImpl class.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class BooleanValueScrubberImplTest {

    @InjectMocks
    private BooleanValueScrubberImpl booleanValueScrubberImpl;

    private static final String VERIFIED = "verified";

    @Before
    public void setup() {
        booleanValueScrubberImpl = new BooleanValueScrubberImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testScrubTrue() {
        Object result = booleanValueScrubberImpl.scrub(VERIFIED, Boolean.TRUE.toString());
        assertTrue("result should be Boolean true", result instanceof Boolean);

        Boolean value = (Boolean) result;
        assertTrue("value should be true", value);
    }

    @Test
    public void testScrubFalse() {
        Object result = booleanValueScrubberImpl.scrub(VERIFIED, Boolean.FALSE.toString());
        assertTrue("result should be Boolean true", result instanceof Boolean);

        Boolean value = (Boolean) result;
        assertFalse("value should be false", value);
    }

    @Test
    public void testScrub_EmptyValue() {
        Object result = booleanValueScrubberImpl.scrub(VERIFIED, "");
        assertNull("result should be null", result);
    }

    @Test
    public void testScrub_NonBooleanValue() {
        Object result = booleanValueScrubberImpl.scrub("other", "test");
        assertNull("result should be null", result);
    }
}
