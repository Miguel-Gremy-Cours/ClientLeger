package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;
import com.google.common.hash.Hashing;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsEmpty.isEmpty;
import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;

@Component
public class InternauteCreateInstance {
    /**
     * Function called to create an instance of a new Internaute
     *
     * @param data Data from HTML with values of the created Internaute
     * @return The new Internaute (class InternauteEntity)
     * @throws Exception In file InternauteExceptionEnum
     */
    public InternauteEntity CreateInternautes(Map<String, String> data) throws Exception {
        // Check if all required values are correct to create new Internaute and throw Exception if that's not the case
        if (isEmpty(data)) {
            throw new Exception(InternauteExceptionEnum.DATA_EMPTY.getFName());
        } else {
            // Creating new Internaute if all values are Ok
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            InternauteEntity internaute = new InternauteEntity();
            internaute.setNom(data.get("nom"));
            internaute.setPrenom(data.get("prenom"));
            internaute.setDateNaissance(Date.valueOf(stringToLocalDate(data.get("date_naissance"))));
            internaute.setIdCivilite(civilite);
            internaute.setLienGoogle(null);
            internaute.setLogin(data.get("login"));
            internaute.setPassword(Hashing.sha256().hashString(data.get("password"), StandardCharsets.UTF_8).toString());
            internaute.setCv(null);
            internaute.setEmail(data.get("email"));
            return internaute;
        }
    }
}
