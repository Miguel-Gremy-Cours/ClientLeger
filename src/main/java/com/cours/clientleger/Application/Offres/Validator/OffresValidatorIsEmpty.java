package com.cours.clientleger.Application.Offres.Validator;

import java.util.Map;

public class OffresValidatorIsEmpty {

    public static boolean isEmpty(Map<String, String> data) {
        boolean isEmpty = false;

        if (data.get("id").equals("")) {
            isEmpty = true;
        }

        return isEmpty;
    }
}
