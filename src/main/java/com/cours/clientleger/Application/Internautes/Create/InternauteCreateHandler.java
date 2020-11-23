package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorGetProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


@Component
public class InternauteCreateHandler {
    @Autowired
    InternauteCreateRequest internauteCreateRequest;
    @Autowired
    InternauteCreateInstance internauteCreateInstance;

    /**
     * Function called to create new Internaute in database
     * This file is checking if function called doesn't return Exception
     *
     * @param data        Data from HTML with values of the created Internaute
     * @param httpSession Data in Http session
     * @return If the creation finished or if there was errors
     * @throws Exception In file InternauteExceptionEnum
     */
    public boolean CreateInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        try {
            // Try creating new Internaute
            internauteCreateRequest.CreateInDatabaseRequest(data);
        } catch (Exception e) {
            // In case of there is an Exception (in file InternauteExceptionEnum)
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternauteExceptionEnum.LOGIN_USED.getFName())) {
                // Check if Login is already used
                problems.add(InternauteExceptionEnum.LOGIN_USED.getFName());
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.EMAIL_USED.getFName())) {
                // Check if Email is already used
                problems.add(InternauteExceptionEnum.EMAIL_USED.getFName());
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.INCORRECT_VALUES.getFName())) {
                // Check if the values are correct (date is date, etc... )
                problems = InternauteValidatorGetProblem.getProblem(internauteCreateInstance.CreateInternautes(data));
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.DATA_EMPTY.getFName())) {
                // Check if data is empty (one or multiple fields are missing)
                problems.add(InternauteExceptionEnum.DATA_EMPTY.getFName());
                httpSession.setAttribute("problems", problems);
            }
            succes = false;
        }
        // Set
        httpSession.setAttribute("data", data);
        return succes;
    }
}
