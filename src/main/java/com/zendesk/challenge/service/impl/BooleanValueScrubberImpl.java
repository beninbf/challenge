package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.service.BooleanValueScrubber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * <code>BooleanValueScrubberImpl</code> implementation of the BooleanValueScrubber interface.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public class BooleanValueScrubberImpl implements BooleanValueScrubber {

    private static Logger logger = LoggerFactory.getLogger(BooleanValueScrubberImpl.class);

    public Object scrub(String field, String value) {
        Object valueToQuery = null;
        if (value.equals(Boolean.TRUE.toString())) {
            valueToQuery = Boolean.TRUE;
        } else if (value.equals(Boolean.FALSE.toString())) {
            valueToQuery =  Boolean.FALSE;
        } else {
            logger.info(String.format("invalid value %s for boolean field", value));
        }
        return valueToQuery;
    }
}
