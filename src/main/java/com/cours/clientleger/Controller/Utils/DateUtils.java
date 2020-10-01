package com.cours.clientleger.Controller.Utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {
    public static LocalDate stringToLocalDate(String string) {
        LocalDate localDate;
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            localDate = LocalDate.parse(string.replace("/", "-"), dateTimeFormatter);
        } catch (Exception e) {
            localDate = null;
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        return localDate;
    }
}
