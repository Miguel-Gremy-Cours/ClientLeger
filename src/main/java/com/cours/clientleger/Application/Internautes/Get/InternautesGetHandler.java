package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Application.Internautes.InternautesGetInstance;
import com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorGetProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Component
public class InternautesGetHandler {
    @Autowired
    InternautesGetRequest internautesGetRequest;
    @Autowired
    InternautesGetInstance internautesGetInstance;

    public boolean GetInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        try {
            internautesGetRequest.GetInDatabaseRequest(data);
        } catch (Exception e) {
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternautesExceptionEnum.INCORRECT_VALUES.getFName())) {
                problems = InternautesValidatorGetProblem.getProblem(internautesGetInstance.GetInternautes(data));
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternautesExceptionEnum.DATA_EMPTY.getFName())) {
                problems.add(InternautesExceptionEnum.DATA_EMPTY.getFName());
                httpSession.setAttribute("problems", problems);
            }
            succes = false;
        }
        return succes;
    }
}
