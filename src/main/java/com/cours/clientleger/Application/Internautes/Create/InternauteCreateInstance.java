package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.Database.Internaute;
import com.google.common.hash.Hashing;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;
import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsEmpty.isEmpty;

@Component
public class InternauteCreateInstance {
    public Internaute CreateInternautes(Map<String, String> data) throws Exception {
        if (isEmpty(data)) {
            throw new Exception(InternauteExceptionEnum.DATA_EMPTY.getFName());
        } else {
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            Internaute internautes = new Internaute(
                    data.get("nom"),
                    data.get("prenom"),
                    stringToLocalDate(data.get("date_naissance")),
                    civilite,
                    null,
                    data.get("login"),
                    Hashing.sha256().hashString(data.get("password"), StandardCharsets.UTF_8).toString(),
                    null,
                    data.get("email")
            );
            return internautes;
        }
    }
}
