package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Application.Internautes.InternautesGetInstance;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorIsSet.isSet;

@Component
public class InternautesGetRequest {
    @Autowired
    InternautesGetInstance internautesGetInstance;
    @Autowired
    InternautesGetResponse internautesGetResponse;

    public void GetInDatabaseRequest(Map<String, String> data) throws Exception {
        Internautes internautes = internautesGetInstance.GetInternautes(data);
        if (isSet(internautes)) {
            internautesGetResponse.GetInDatabaseResponse(internautes);
        } else {
            throw new Exception(InternautesExceptionEnum.INCORRECT_VALUES.getFName());
        }
    }
}