package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsSet.isSet;

@Component
public class InternauteCreateRequest {
    @Autowired
    InternauteCreateInstance internauteCreateInstance;
    @Autowired
    InternauteCreateResponse internauteCreateResponse;

    public void CreateInDatabaseRequest(Map<String, String> data) throws Exception {
        InternauteEntity internautes = internauteCreateInstance.CreateInternautes(data);
        if (isSet(internautes)) {
            internauteCreateResponse.CreateInDatabaseResponse(data);
        } else {
            throw new Exception(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
        }

    }
}
