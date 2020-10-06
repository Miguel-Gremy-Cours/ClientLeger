package com.cours.clientleger.Application.Internautes;

import com.cours.clientleger.Model.Database.Internautes;

import java.util.Map;

import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;

public class InternautesCreateInstance {
    public Internautes CreateInternautes(Map<String, String> data) throws Exception {
        if (data.isEmpty()) {
            throw new Exception(InternautesExceptionEnum.DATA_EMPTY.getFName());
        } else {
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            Internautes internautes = new Internautes(
                    data.get("nom"),
                    data.get("prenom"),
                    stringToLocalDate(data.get("date_naissance")),
                    civilite,
                    null,
                    data.get("login"),
                    String.valueOf(data.get("password").hashCode()),
                    null,
                    data.get("email")
            );
            return internautes;
        }
    }
}
