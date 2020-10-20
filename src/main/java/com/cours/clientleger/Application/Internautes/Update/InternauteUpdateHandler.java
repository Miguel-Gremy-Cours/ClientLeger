package com.cours.clientleger.Application.Internautes.Update;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorGetProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Component
public class InternauteUpdateHandler {
    @Autowired
    InternauteUpdateRequest internauteUpdateRequest;
    @Autowired
    InternauteUpdateInstance internauteUpdateInstance;

    public boolean UpdateInternautes(Map<String, String> data, HttpSession httpSession) throws Exception {
        boolean succes = true;
        try {
            internauteUpdateRequest.UpdateInDatabaseRequest(data);
            httpSession.setAttribute("data", data);
        } catch (Exception e) {
            List<String> problems = new ArrayList<>();
            if (e.getMessage().equals(InternauteExceptionEnum.INCORRECT_VALUES.getFName())) {
                problems = InternauteValidatorGetProblem.getProblem(internauteUpdateInstance.UpdateInternautes(data));
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
