package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternautesCreateInstance;
import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.InternautesValidatorIsSet.isSet;

@Component
public class InternautesCreateResponse {
    @Autowired
    InternautesRepository internautesRepository;

    public void CreateInDatabaseResponse(Map<String, String> data) throws Exception {
        Internautes internautes = new InternautesCreateInstance().CreateInternautes(data);
        if (isSet(internautes)) {
            internautesRepository.save(internautes);
        } else {
            throw new Exception(InternautesExceptionEnum.INCORRECT_VALUES.getFName());
        }
    }
}
