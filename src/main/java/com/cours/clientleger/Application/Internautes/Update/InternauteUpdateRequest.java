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

    /**
     * Function that call other function to create the Internaute and update it in database
     *
     * @param data Data from HTML with values of the updated Internaute
     * @throws Exception  In file InternauteExceptionEnum
     */
    public void UpdateInDatabaseRequest(Map<String, String> data) throws Exception {
        // Create new Internaute with the values of updated Internaute
        InternauteEntity internaute = internauteUpdateInstance.UpdateInternautes(data);
        if (isSet(internaute)) {
            // If Internaute fileds are correct, update it in database
            internauteUpdateResponse.UpdateInDatabaseResponse(data);
        } else {
            // If Internaute fields are not correct, throw Exception
            throw new Exception(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
        }
    }
}
