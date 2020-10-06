package com.cours.clientleger.Application.Internautes.Create;

import com.cours.clientleger.Application.Internautes.InternautesCreateInstance;
import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorGetProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Component
public class InternautesCreateHandler {
    @Autowired
    InternautesCreateRequest internautesCreateRequest;
    @Autowired
    InternautesCreateInstance internautesCreateInstance;

    public boolean CreateInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        try {
            internautesCreateRequest.CreateInDatabaseRequest(data);
        } catch (Exception e) {
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternautesExceptionEnum.LOGIN_USED.getFName())) {
                problems.add(InternautesExceptionEnum.LOGIN_USED.getFName());
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternautesExceptionEnum.EMAIL_USED.getFName())) {
                problems.add(InternautesExceptionEnum.EMAIL_USED.getFName());
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternautesExceptionEnum.INCORRECT_VALUES.getFName())) {
                problems = InternautesValidatorGetProblem.getProblem(internautesCreateInstance.CreateInternautes(data));
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
