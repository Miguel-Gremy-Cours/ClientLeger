package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.Database.Internaute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InternauteGetResponse {
    @Autowired
    InternauteRepository internauteRepository;
    @Autowired
    InternauteGetInstance internauteGetInstance;

    public Map<String, String> GetInDatabaseResponse(Internaute internaute) {
        internauteRepository.save(internaute);

        Map<String, String> dataOut = new HashMap<>();
        dataOut.put("nom", internaute.getNom());
        dataOut.put("prenom", internaute.getPrenom());
        dataOut.put("date_naissance", internaute.getDateNaissance().toString());
        dataOut.put("civilite", String.valueOf(internaute.getIdCivilite()));
        dataOut.put("lien_google", internaute.getLienGoogle());
        dataOut.put("login", internaute.getLogin());
        dataOut.put("password", internaute.getPassword());
        dataOut.put("cv_name", internaute.getCv());
        dataOut.put("email", internaute.getEmail());

        return dataOut;
    }
}
