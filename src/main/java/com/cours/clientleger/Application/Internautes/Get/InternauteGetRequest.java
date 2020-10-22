package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsSet.isSet;

@Component
public class InternauteGetRequest {
    @Autowired
    InternauteGetInstance internauteGetInstance;
    @Autowired
    InternauteGetResponse internauteGetResponse;

    public Map<String, String> GetInDatabaseRequest(Map<String, String> data) throws Exception {
        InternauteEntity internautes = internauteGetInstance.GetInternautes(data);
        Map<String, String> dataOut;
        if (isSet(internautes)) {
            dataOut = internauteGetResponse.GetInDatabaseResponse(internautes);
        } else {
            throw new Exception(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
        }

        return dataOut;
    }
}
