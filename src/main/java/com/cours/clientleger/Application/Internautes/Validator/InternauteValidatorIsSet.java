package com.cours.clientleger.Application.Internautes.Validator;

import com.cours.clientleger.Model.Database.Internaute;

import org.apache.commons.validator.routines.EmailValidator;

import java.sql.Date;
import java.time.LocalDate;

public class InternauteValidatorIsSet {
    public static boolean isSet(Internaute internautes) {
        boolean isSet = true;
        if (internautes != null) {
            if (internautes.getNom().equals("")) {
                isSet = false;
            } else if (internautes.getPrenom().equals("")) {
                isSet = false;
            } else if (internautes.getIdCivilite() != 1 && internautes.getIdCivilite() != 2) {
                isSet = false;
            } else if (internautes.getDateNaissance().equals(LocalDate.now())) {
                isSet = false;
            } else if (internautes.getLogin().equals("")) {
                isSet = false;
            } else if (internautes.getPassword().equals("0")) {
                isSet = false;
            } else if (!internautes.getEmail().equals("")) {
                if (!EmailValidator.getInstance().isValid(internautes.getEmail())) {
                    isSet = false;
                }
            } else {
                isSet = false;
            }
        } else {
            isSet = false;
        }
        return isSet;
    }
}
