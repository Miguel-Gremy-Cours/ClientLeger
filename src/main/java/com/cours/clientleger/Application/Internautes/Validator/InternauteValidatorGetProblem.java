package com.cours.clientleger.Application.Internautes.Validator;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class InternauteValidatorGetProblem {
    public static List<String> getProblem(InternauteEntity internautes) {
        List<String> problems = new ArrayList<>();
        if (internautes != null) {
            if (internautes.getNom().equals("")) {
                problems.add(InternauteExceptionEnum.LAST_NAME.getFName());
            }
            if (internautes.getPrenom().equals("")) {
                problems.add(InternauteExceptionEnum.FIRST_NAME.getFName());
            }
            if (internautes.getIdCivilite() != 1 && internautes.getIdCivilite() != 2) {
                problems.add(InternauteExceptionEnum.CIVILITE.getFName());
            }
            if (!isNull(internautes.getDateNaissance())) {
                if (internautes.getDateNaissance().equals(LocalDate.now())) {
                    problems.add(InternauteExceptionEnum.BIRTH_DATE.getFName());
                }
            } else {
                problems.add(InternauteExceptionEnum.BIRTH_DATE.getFName());
            }
            if (internautes.getLogin().equals("")) {
                problems.add(InternauteExceptionEnum.LOGIN.getFName());
            }
            if (internautes.getPassword().equals("0")) {
                problems.add(InternauteExceptionEnum.PASSWORD.getFName());
            }
            if (!internautes.getEmail().equals("")) {
                if (!EmailValidator.getInstance().isValid(internautes.getEmail())) {
                    problems.add(InternauteExceptionEnum.EMAIL.getFName());
                }
            } else {
                problems.add(InternauteExceptionEnum.EMAIL_EMPTY.getFName());
            }
        } else {
            problems.remove(InternauteExceptionEnum.INCORRECT_VALUES.getFName());
            problems.add(InternauteExceptionEnum.ERROR_LOGIN.getFName());
        }

        return problems;
    }
}
