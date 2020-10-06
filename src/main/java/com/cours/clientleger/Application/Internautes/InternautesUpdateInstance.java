package com.cours.clientleger.Application.Internautes;

import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorIsEmpty.isEmpty;
import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;

@Component
public class InternautesUpdateInstance {
    @Autowired
    InternautesRepository internautesRepository;

    public Internautes UpdateInternautes(Map<String, String> data) throws Exception {
        if (isEmpty(data)) {
            throw new Exception(InternautesExceptionEnum.DATA_EMPTY.getFName());
        } else {
            Internautes internautes = internautesRepository.getByLoginAndPassword(data.get("login"), String.valueOf(data.get("password").hashCode()));
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            internautes.setNom(data.get("nom"));
            internautes.setPrenom(data.get("prenom"));
            internautes.setDate_naissance(stringToLocalDate(data.get("date_naissance")));
            internautes.setCivilite(civilite);
            internautes.setLien_google(null);
            internautes.setLogin(data.get("login"));
            internautes.setPassword(String.valueOf(data.get("password").hashCode()));
            internautes.setCv_name(null);
            internautes.setEmail(data.get("email"));
            return internautes;
        }
    }
}