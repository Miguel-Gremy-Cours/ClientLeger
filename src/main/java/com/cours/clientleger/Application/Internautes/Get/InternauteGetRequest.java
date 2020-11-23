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

    /**
     * Function called to call another function to get an Internaute
     *
     * @param data Data from HTML with values of the Internaute get
     * @return The Internaute information if logged
     * @throws Exception In file InternauteExceptionEnum
     */
    public Map<String, String> GetInDatabaseRequest(Map<String, String> data) throws Exception {
        // Create new Internaute
        InternauteEntity internautes = internauteGetInstance.GetInternautes(data);
        Map<String, String> dataOut;
        if (isSet(internautes)) {
            // If Internaute is correct, get it from database and return it to the view
            dataOut = internauteGetResponse.GetInDatabaseResponse(internautes);
        } else {
            // If not correct, throw Exception that will be treated in Handler
            throw new Exception(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
        }

        return dataOut;
    }
}
