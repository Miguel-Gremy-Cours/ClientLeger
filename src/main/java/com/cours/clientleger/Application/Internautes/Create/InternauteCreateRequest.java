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

    /**
     * Function called to call another function to create a new Internaute
     * And call another function to save it in database
     *
     * @param data Data from HTML with values of the created Internaute
     * @throws Exception
     */
    public void CreateInDatabaseRequest(Map<String, String> data) throws Exception {
        // Create new Internaute
        InternauteEntity internautes = internauteCreateInstance.CreateInternautes(data);
        // And check if the internaute is not null and it's values are correct
        if (isSet(internautes)) {
            // If Internaute is correct, save it in database
            internauteCreateResponse.CreateInDatabaseResponse(data);
        } else {
            // If not correct, throw Exception that will be treated in Handler
            throw new Exception(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
        }

    }
}
