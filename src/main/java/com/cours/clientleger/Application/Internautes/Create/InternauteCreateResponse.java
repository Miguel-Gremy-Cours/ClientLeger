package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternauteCreateResponse {
    @Autowired
    InternauteRepository internauteRepository;
    @Autowired
    InternauteCreateInstance internauteCreateInstance;

    /**
     * Function called to check if Internaute already exists in database
     * And save Internaute in database if doesn't exists
     *
     * @param data Data from HTML with values of the created Internaute
     * @throws Exception In file InternauteExceptionEnum
     */
    public void CreateInDatabaseResponse(Map<String, String> data) throws Exception {
        // Check if Email is already used in database
        if (!internauteRepository.existsByEmail(data.get("email"))) {
            // Check if login is already used in database
            if (!internauteRepository.existsByLogin(data.get("login"))) {
                // If not used, create new Internaute and save it in database
                InternauteEntity internaute = internauteCreateInstance.CreateInternautes(data);
                internauteRepository.save(internaute);
            } else {
                // If login is already used, throw Exception
                throw new Exception(InternauteExceptionEnum.LOGIN_USED.getFName());
            }
        } else {
            // If Email is already used, throw Exception
            throw new Exception(InternauteExceptionEnum.EMAIL_USED.getFName());
        }
    }
}
