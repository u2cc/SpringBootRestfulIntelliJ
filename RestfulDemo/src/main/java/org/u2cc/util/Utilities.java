package org.u2cc.util;

import org.u2cc.constant.Constants;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(Constants.DB_DATE_FORMAT);

    public static java.sql.Timestamp parseTimestamp(String timestamp){
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String formatTimestamp(Timestamp sqlTimestamp) {
        Date date = new Date();
        date.setTime(sqlTimestamp.getTime());
        String formattedTimestamp = new SimpleDateFormat(Constants.DB_DATE_FORMAT).format(date);
        return formattedTimestamp;
    }
}
