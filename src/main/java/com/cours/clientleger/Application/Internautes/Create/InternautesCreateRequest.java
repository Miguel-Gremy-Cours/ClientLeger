package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternautesCreateInstance;
import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorIsSet.isSet;

@Component
public class InternautesCreateRequest {
    @Autowired
    InternautesCreateInstance internautesCreateInstance;
    @Autowired
    InternautesCreateResponse internautesCreateResponse;

    public void CreateInDatabaseRequest(Map<String, String> data) throws Exception {
        Internautes internautes = internautesCreateInstance.CreateInternautes(data);
        if (isSet(internautes)) {
            internautesCreateResponse.CreateInDatabaseResponse(data);
        } else {
            throw new Exception(InternautesExceptionEnum.INCORRECT_VALUES.getFName());
        }

    }
}
