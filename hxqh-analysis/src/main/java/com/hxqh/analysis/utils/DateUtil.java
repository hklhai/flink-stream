package com.hxqh.analysis.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lin
 */
public class DateUtil {

    public static String getDateby(long timestamp, String dateString) {
        Date date = new Date(timestamp);
        DateFormat dateFormat = new SimpleDateFormat(dateString);
        String formatdate = dateFormat.format(date);
        return formatdate;
    }


    public static long getDateByCondition(long timestamp, String dateString) throws ParseException {
        Date datetemp = new Date(timestamp);
        DateFormat dateFormat = new SimpleDateFormat(dateString);
        String formatdate = dateFormat.format(datetemp);
        Date date = dateFormat.parse(formatdate);
        return date.getTime();
    }
}
