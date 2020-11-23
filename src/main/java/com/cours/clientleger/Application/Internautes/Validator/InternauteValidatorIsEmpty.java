package com.cours.clientleger.Application.Internautes.Validator;

import java.util.Map;

public class InternauteValidatorIsEmpty {
    /**
     * Function that check if the data from view is empty or not
     *
     * @param data Data from HTML with values of the updated Internaute
     * @return if one field is empty or not
     */
    public static boolean isEmpty(Map<String, String> data) {
        boolean isEmpty = false;
        int size = data.size();
        int celEmpty = 0;
        for (String value : data.values()) {
            if (value.equals("")) {
                celEmpty++;
            }
        }
        if (celEmpty == size) {
            isEmpty = true;
        }
        return isEmpty;
    }
}
