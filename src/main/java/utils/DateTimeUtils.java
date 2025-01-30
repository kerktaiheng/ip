package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    //This specifies the DateTime format for all DateTime objects in the program
    public static final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Parses a string representation of a date and time into a LocalDateTime
     * object.
     *
     * @param dateTime the string representation of the date and time
     * @return the parsed LocalDateTime object
     */
    public static LocalDateTime parseDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIMEFORMATTER);
    }

    /**
     * Formats a LocalDateTime object into a string representation.
     *
     * @param dateTime the LocalDateTime object to format
     * @return the formatted string representation of the date and time
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATETIMEFORMATTER);
    }
}
