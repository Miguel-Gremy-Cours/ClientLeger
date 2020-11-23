package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InternauteUpdateResponse {
    @Autowired
    InternauteRepository internauteRepository;
    @Autowired
    InternauteUpdateInstance internauteUpdateInstance;

    /**
     * Function that save the updated Internaute in database
     *
     * @param data Data from HTML with values of the updated Internaute
     * @throws Exception  In file InternauteExceptionEnum
     */
    public void UpdateInDatabaseResponse(Map<String, String> data) throws Exception {
        InternauteEntity internaute = internauteUpdateInstance.UpdateInternautes(data);
        internauteRepository.save(internaute);
    }
}
