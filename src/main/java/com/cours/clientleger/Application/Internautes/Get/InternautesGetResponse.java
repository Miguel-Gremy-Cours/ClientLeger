package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternautesGetInstance;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InternautesGetResponse {
    @Autowired
    InternautesRepository internautesRepository;
    @Autowired
    InternautesGetInstance internautesGetInstance;

    public void GetInDatabaseResponse(Internautes internautes) {
        internautesRepository.save(internautes);
    }
}
