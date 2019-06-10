package com.zendesk.challenge.service;

/**
 *
 * <code>BooleanValueScrubber</code> interface for scrubbing query paramater values.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
 */
public interface BooleanValueScrubber {

    /**
     * BooleanValueScrubber - validates a boolean for property object casting.
     *
     * @param field the field
     * @param value the value
     * @return Object
     */
    Object scrub(String field, String value) ;
}
