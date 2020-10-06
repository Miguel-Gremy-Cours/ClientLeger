package com.cours.clientleger.Application.Internautes.Validator;

import java.util.Map;

public class InternautesValidatorIsEmpty {
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
