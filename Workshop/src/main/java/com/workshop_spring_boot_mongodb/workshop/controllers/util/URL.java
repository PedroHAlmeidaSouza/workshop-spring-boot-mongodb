package com.workshop_spring_boot_mongodb.workshop.controllers.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodeParam(String param) {
        return URLDecoder.decode(param, StandardCharsets.UTF_8);
    }

    public static Date convertDate(String textDate, Date defaultDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
