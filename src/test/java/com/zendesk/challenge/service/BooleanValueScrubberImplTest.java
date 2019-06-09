package com.zendesk.challenge.service;

import com.zendesk.challenge.service.impl.BooleanValueScrubberImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

    private static final Set<String> booleanTypes = new HashSet<>();
    {
        booleanTypes.add(VERIFIED);
    }

    @Before
    public void setup() {
        booleanValueScrubberImpl = new BooleanValueScrubberImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testScrubTrue() {
        Object result = booleanValueScrubberImpl.scrub(booleanTypes, VERIFIED, Boolean.TRUE.toString());
        assertTrue("result should be Boolean true", result instanceof Boolean);

        Boolean value = (Boolean) result;
        assertTrue("value should be true", value);
    }

    @Test
    public void testScrubFalse() {
        Object result = booleanValueScrubberImpl.scrub(booleanTypes, VERIFIED, Boolean.FALSE.toString());
        assertTrue("result should be Boolean true", result instanceof Boolean);

        Boolean value = (Boolean) result;
        assertFalse("value should be false", value);
    }

    @Test
    public void testScrub_EmptyValue() {
        Object result = booleanValueScrubberImpl.scrub(booleanTypes, VERIFIED, "");
        assertNull("result should be null", result);
    }

    @Test
    public void testScrub_NonBooleanValue() {
        Object result = booleanValueScrubberImpl.scrub(booleanTypes, "other", "test");
        assertNotNull("result should be not null", result);

        String value = (String) result;
        assertEquals("result should be 'test'", "test", value);
    }
}
