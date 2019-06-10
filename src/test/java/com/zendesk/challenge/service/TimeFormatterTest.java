package com.zendesk.challenge.service;

import com.zendesk.challenge.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class TimeFormatterTest {

    private static final String DATE_MODEL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @InjectMocks
    TimeFormatter timeFormatter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStringFromTimeStamp() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String timeStampString = timeFormatter.getStringFromTimeStamp(timestamp);
        assertNotNull("string should not be null", timeStampString);
    }

    @Test
    public void testGetDateFromString() {
        Date result = timeFormatter.getDateFromString("2016-04-14T08:32:31 -10:00");
        assertNotNull("date should not be null", result);
    }

    @Test
    public void testGetDateFromModel() {
        Date result = timeFormatter.getDateFromModelString("2016-04-14 08:32:31");
        assertNotNull("date should not be null", result);
    }
}
