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

    public boolean GetInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        String passwordClear = data.get("password");
        try {
            data = internauteGetRequest.GetInDatabaseRequest(data);
            httpSession.setAttribute("data", data);
            httpSession.setAttribute("passwordClear", passwordClear);
            httpSession.setAttribute("isLoged", true);
            httpSession.removeAttribute("problems");
        } catch (Exception e) {
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternauteExceptionEnum.INCORRECT_VALUES.getFName())) {
                problems = InternauteValidatorGetProblem.getProblem(internauteGetInstance.GetInternautes(data));
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.DATA_EMPTY.getFName())) {
                problems.add(InternauteExceptionEnum.DATA_EMPTY.getFName());
                httpSession.setAttribute("problems", problems);
            }
            succes = false;
        }
        return succes;
    }
}
