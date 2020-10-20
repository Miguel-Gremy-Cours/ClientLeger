package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.Database.Internaute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternauteCreateResponse {
    @Autowired
    InternauteRepository internauteRepository;
    @Autowired
    InternauteCreateInstance internauteCreateInstance;

    public void CreateInDatabaseResponse(Map<String, String> data) throws Exception {
        if (!internauteRepository.existsByEmail(data.get("email"))) {
            if (!internauteRepository.existsByLogin(data.get("login"))) {
                Internaute internautes = internauteCreateInstance.CreateInternautes(data);
                internauteRepository.save(internautes);
            } else {
                throw new Exception(InternauteExceptionEnum.LOGIN_USED.getFName());
            }
        } else {
            throw new Exception(InternauteExceptionEnum.EMAIL_USED.getFName());
        }
    }
}
