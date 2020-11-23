package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;
import com.google.common.hash.Hashing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsEmpty.isEmpty;
import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;

@Component
public class InternauteUpdateInstance {
    @Autowired
    InternauteRepository internauteRepository;

    /**
     * Function that create an Internaute with the values of Login and Password
     *
     * @param data Data from HTML with values of the updated Internaute
     * @return The Updated Internaute Object (InternauteEntity)
     * @throws Exception
     */
    public InternauteEntity UpdateInternautes(Map<String, String> data) throws Exception {
        if (isEmpty(data)) {
            // Check if Internaute fields are correct
            throw new Exception(InternauteExceptionEnum.DATA_EMPTY.getFName());
        } else {
            InternauteEntity internautes = internauteRepository.getByLoginAndPassword(data.get("login"), Hashing.sha256().hashString(data.get("password"), StandardCharsets.UTF_8).toString());
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            internautes.setNom(data.get("nom"));
            internautes.setPrenom(data.get("prenom"));
            internautes.setDateNaissance(Date.valueOf(stringToLocalDate(data.get("date_naissance"))));
            internautes.setIdCivilite(civilite);
            internautes.setLienGoogle(null);
            internautes.setLogin(data.get("login"));
            internautes.setPassword(Hashing.sha256().hashString(data.get("password"), StandardCharsets.UTF_8).toString());
            internautes.setCv(null);
            internautes.setEmail(data.get("email"));
            return internautes;
        }
    }
}