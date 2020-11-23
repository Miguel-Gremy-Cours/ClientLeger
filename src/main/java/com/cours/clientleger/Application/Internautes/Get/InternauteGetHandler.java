package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorGetProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Component
public class InternauteGetHandler {
    @Autowired
    InternauteGetRequest internauteGetRequest;
    @Autowired
    InternauteGetInstance internauteGetInstance;

    /**
     * Function called to get an Internaute in database
     * This file is checking if function called doesn't return Exception
     *
     * @param data        Data from HTML with values of the Internaute get
     * @param httpSession Data in Http session
     * @return If getting an Internaute finished or if there was errors
     * @throws Exception
     */
    public boolean GetInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        // Store password in clear (VERY BAD but no choice for the moment)
        String passwordClear = data.get("password");
        try {
            // Try getting the internaute by the Login and Password (hashed with SHA-256) in database
            data = internauteGetRequest.GetInDatabaseRequest(data);
            // Set session values of the user
            httpSession.setAttribute("data", data);
            // Store password clear in session (VERY BAD but no choice for the moment)
            httpSession.setAttribute("passwordClear", passwordClear);
            // Create boolean isLoged for view
            httpSession.setAttribute("isLoged", true);
            // Remove all connection problems if exists
            httpSession.removeAttribute("problems");
        } catch (Exception e) {
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternauteExceptionEnum.INCORRECT_VALUES.getFName())) {
                // Check if values entered in view are correct for the login
                problems = InternauteValidatorGetProblem.getProblem(internauteGetInstance.GetInternautes(data));
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.DATA_EMPTY.getFName())) {
                // Check if the data is empty (one or multiple fields are missing)
                problems.add(InternauteExceptionEnum.DATA_EMPTY.getFName());
                httpSession.setAttribute("problems", problems);
            }
            succes = false;
        }
        return succes;
    }
}
