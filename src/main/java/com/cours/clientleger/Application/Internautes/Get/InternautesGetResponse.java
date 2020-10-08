package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InternautesGetResponse {
    @Autowired
    InternautesRepository internautesRepository;
    @Autowired
    InternautesGetInstance internautesGetInstance;

    public Map<String, String> GetInDatabaseResponse(Internautes internautes) {
        internautesRepository.save(internautes);

        Map<String, String> dataOut = new HashMap<>();
        dataOut.put("nom", internautes.getNom());
        dataOut.put("prenom", internautes.getPrenom());
        dataOut.put("date_naissance", internautes.getDate_naissance().toString());
        dataOut.put("civilite", String.valueOf(internautes.getCivilite()));
        dataOut.put("lien_google", internautes.getLien_google());
        dataOut.put("login", internautes.getLogin());
        dataOut.put("password", internautes.getPassword());
        dataOut.put("cv_name", internautes.getCv_name());
        dataOut.put("email", internautes.getEmail());

        return dataOut;
    }
}
