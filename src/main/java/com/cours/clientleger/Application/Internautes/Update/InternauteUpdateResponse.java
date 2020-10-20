package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.Database.Internaute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternauteUpdateResponse {
    @Autowired
    InternauteRepository internauteRepository;
    @Autowired
    InternauteUpdateInstance internauteUpdateInstance;

    public void UpdateInDatabaseResponse(Map<String, String> data) throws Exception {
        Internaute internaute = internauteUpdateInstance.UpdateInternautes(data);
        internauteRepository.save(internaute);
    }
}
