package com.cours.clientleger.Application.Internautes.Validator;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InternauteValidatorIsEmpty {
    /**
     * Function that check if the data from view is empty or not
     *
     * @param data Data from HTML with values of the updated Internaute
     * @return if one field is empty or not
     */
    public static boolean isEmpty(Map<String, String> data) {
        boolean isEmpty = false;
        AtomicInteger celEmpty = new AtomicInteger();
        data.forEach((s, s2) -> {
            if (s2.isEmpty()) {
                celEmpty.getAndIncrement();
            }
        });
        if (celEmpty.get() >= 1) {
            isEmpty = true;
        }
        return isEmpty;
    }
}
