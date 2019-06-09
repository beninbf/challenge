package com.zendesk.challenge.service;

import java.util.Set;

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
     * BooleanValueScrubber - validates field against a known set of
     * boolean and returns the appropriate object type.
     *
     * @param field the field
     * @param value the value
     * @return Object
     */
    Object scrub(Set<String> booleanTypes, String field, String value) ;
}
