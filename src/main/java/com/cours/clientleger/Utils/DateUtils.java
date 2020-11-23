package com.cours.clientleger.Utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {
    /**
     * Function that convert String to LocalDate
     *
     * @param string Date under a String variable
     * @return LocalDate variable
     */
    public static LocalDate stringToLocalDate(String string) {
        LocalDate localDate;
        try {
            // Create the formatter
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Create the formated date from the String
            localDate = LocalDate.parse(string.replace("/", "-"), dateTimeFormatter);
        } catch (Exception e) {
            localDate = null;
            System.out.println(e.getMessage());
        }
        return localDate;
    }
}
