package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternautesCreateInstance;
import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternautesCreateResponse {
    @Autowired
    InternautesRepository internautesRepository;
    @Autowired
    InternautesCreateInstance internautesCreateInstance;

    public void CreateInDatabaseResponse(Map<String, String> data) throws Exception {
        if (!internautesRepository.existsByEmail(data.get("email"))) {
            if (!internautesRepository.existsByLogin(data.get("login"))) {
                Internautes internautes = internautesCreateInstance.CreateInternautes(data);
                internautesRepository.save(internautes);
            } else {
                throw new Exception(InternautesExceptionEnum.LOGIN_USED.getFName());
            }
        } else {
            throw new Exception(InternautesExceptionEnum.EMAIL_USED.getFName());
        }
    }
}
