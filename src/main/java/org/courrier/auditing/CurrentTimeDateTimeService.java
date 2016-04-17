package org.courrier.auditing;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by SimonPascal on 04/16/2016.
 */
public class CurrentTimeDateTimeService implements DateTimeService{
    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        return ZonedDateTime.now();
    }
}
