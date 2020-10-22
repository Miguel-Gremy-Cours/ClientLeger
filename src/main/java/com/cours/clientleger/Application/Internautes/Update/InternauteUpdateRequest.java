package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsSet.isSet;

@Component
public class InternauteUpdateRequest {
    @Autowired
    InternauteUpdateInstance internauteUpdateInstance;
    @Autowired
    InternauteUpdateResponse internauteUpdateResponse;

    public void UpdateInDatabaseRequest(Map<String, String> data) throws Exception {
        InternauteEntity internaute = internauteUpdateInstance.UpdateInternautes(data);
        if (isSet(internaute)) {
            internauteUpdateResponse.UpdateInDatabaseResponse(data);
        } else {
            throw new Exception(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
        }
    }
}
