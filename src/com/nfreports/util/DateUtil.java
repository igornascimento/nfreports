package com.nfreports.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Date format conversion
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class DateUtil {

    private static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);


    public static String format(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    public static LocalDateTime parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDateTime::from);
        } catch (DateTimeParseException ex) {
            //TODO logger
            return null;
        }
    }

    /**
     * Checks the string whether it is a valid date
     */
    public static boolean validateDate(String dateString) {
        //try to parse the string
        return DateUtil.parse(dateString) != null;
    }

}
