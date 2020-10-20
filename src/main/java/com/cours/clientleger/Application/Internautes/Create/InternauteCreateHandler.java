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

    public boolean CreateInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        try {
            internauteCreateRequest.CreateInDatabaseRequest(data);
        } catch (Exception e) {
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternauteExceptionEnum.LOGIN_USED.getFName())) {
                problems.add(InternauteExceptionEnum.LOGIN_USED.getFName());
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.EMAIL_USED.getFName())) {
                problems.add(InternauteExceptionEnum.EMAIL_USED.getFName());
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.INCORRECT_VALUES.getFName())) {
                problems = InternauteValidatorGetProblem.getProblem(internauteCreateInstance.CreateInternautes(data));
                httpSession.setAttribute("problems", problems);
            } else if (e.getMessage().equals(InternauteExceptionEnum.DATA_EMPTY.getFName())) {
                problems.add(InternauteExceptionEnum.DATA_EMPTY.getFName());
                httpSession.setAttribute("problems", problems);
            }
            succes = false;
        }
        httpSession.setAttribute("data", data);
        return succes;
    }
}
