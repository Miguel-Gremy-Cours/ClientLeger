package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternautesCreateRequest {
    @Autowired
    InternautesRepository internautesRepository;

    public void CreateInDatabaseRequest(Map<String, String> data) throws Exception {
        if (!internautesRepository.existsByEmail(data.get("email"))) {
            if (internautesRepository.existsByLogin(data.get("login"))) {
                InternautesCreateResponse internautesCreateResponse = new InternautesCreateResponse();
                internautesCreateResponse.CreateInDatabaseResponse(data);
            } else {
                throw new Exception(InternautesExceptionEnum.LOGIN_USED.getFName());
            }
        } else {
            throw new Exception(InternautesExceptionEnum.EMAIL_USED.getFName());
        }
    }
}
