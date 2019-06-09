package com.zendesk.challenge.service.impl;

import com.zendesk.challenge.service.BooleanValueScrubber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

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

    public Object scrub(Set<String> booleanTypes, String field, String value) {
        Object valueToQuery = null;
        if (booleanTypes.contains(field)) {
            if (value.equals(Boolean.TRUE.toString())) {
                valueToQuery = Boolean.TRUE;
            } else if (value.equals(Boolean.FALSE.toString())) {
                valueToQuery =  Boolean.FALSE;
            } else if (!value.isEmpty()) {
                logger.info(String.format("invalid value %s for boolean field", value));
            }
        } else {
            valueToQuery = !value.isEmpty() ? value : null;
        }
        return valueToQuery;
    }
}
