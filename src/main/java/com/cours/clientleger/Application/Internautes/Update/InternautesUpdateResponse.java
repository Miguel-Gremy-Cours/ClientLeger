package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternautesUpdateResponse {
    @Autowired
    InternautesRepository internautesRepository;
    @Autowired
    InternautesUpdateInstance internautesUpdateInstance;

    public void UpdateInDatabaseResponse(Map<String, String> data) throws Exception {
        Internautes internautes = internautesUpdateInstance.UpdateInternautes(data);
        internautesRepository.save(internautes);
    }
}
