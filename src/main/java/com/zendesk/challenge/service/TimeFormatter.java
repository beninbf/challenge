package com.zendesk.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * <code>TimeFormatter</code> object which holds time formatting methods.
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
public class TimeFormatter {

    private static Logger logger = LoggerFactory.getLogger(TimeFormatter.class);

    private static final String DATE_MODEL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss XXX";


    public String getStringFromTimeStamp(Timestamp timestamp) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_MODEL_FORMAT);
            Date date = new Date(timestamp.getTime());
            return simpleDateFormat.format(date);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public Timestamp getDateFromString(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
            Date d = simpleDateFormat.parse(date);
            return new Timestamp(d.getTime());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public Timestamp getDateFromModelString(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_MODEL_FORMAT);
            Date d = simpleDateFormat.parse(date);
            return new Timestamp(d.getTime());
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }
}
