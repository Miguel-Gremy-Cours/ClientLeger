package com.cours.clientleger.Application.Internautes.Validator;

import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Model.Database.Internautes;

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class InternautesValidatorGetProblem {
    public static List<String> getProblem(Internautes internautes) {
        List<String> problems = new ArrayList<>();
        if (internautes != null) {
            if (internautes.getNom().equals("")) {
                problems.add(InternautesExceptionEnum.LAST_NAME.getFName());
            }
            if (internautes.getPrenom().equals("")) {
                problems.add(InternautesExceptionEnum.FIRST_NAME.getFName());
            }
            if (internautes.getCivilite() != 1 && internautes.getCivilite() != 2) {
                problems.add(InternautesExceptionEnum.CIVILITE.getFName());
            }
            if (!isNull(internautes.getDate_naissance())) {
                if (internautes.getDate_naissance().equals(LocalDate.now())) {
                    problems.add(InternautesExceptionEnum.BIRTH_DATE.getFName());
                }
            } else {
                problems.add(InternautesExceptionEnum.BIRTH_DATE.getFName());
            }
            if (internautes.getLogin().equals("")) {
                problems.add(InternautesExceptionEnum.LOGIN.getFName());
            }
            if (internautes.getPassword().equals("0")) {
                problems.add(InternautesExceptionEnum.PASSWORD.getFName());
            }
            if (!internautes.getEmail().equals("")) {
                if (!EmailValidator.getInstance().isValid(internautes.getEmail())) {
                    problems.add(InternautesExceptionEnum.EMAIL.getFName());
                }
            } else {
                problems.add(InternautesExceptionEnum.EMAIL_EMPTY.getFName());
            }
        } else {
            problems.remove(InternautesExceptionEnum.INCORRECT_VALUES.getFName());
            problems.add(InternautesExceptionEnum.ERROR_LOGIN.getFName());
        }

        return problems;
    }
}
