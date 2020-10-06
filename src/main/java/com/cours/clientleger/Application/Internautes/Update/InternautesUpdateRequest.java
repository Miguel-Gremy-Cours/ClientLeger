package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Application.Internautes.InternautesUpdateInstance;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorIsSet.isSet;

@Component
public class InternautesUpdateRequest {
    @Autowired
    InternautesUpdateInstance internautesUpdateInstance;
    @Autowired
    InternautesUpdateResponse internautesUpdateResponse;

    public void UpdateInDatabaseRequest(Map<String, String> data) throws Exception {
        Internautes internautes = internautesUpdateInstance.UpdateInternautes(data);
        if (isSet(internautes)) {
            internautesUpdateResponse.UpdateInDatabaseResponse(data);
        } else {
            throw new Exception(InternautesExceptionEnum.INCORRECT_VALUES.getFName());
        }
    }
}
