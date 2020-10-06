package com.cours.clientleger.Application.Internautes;

import com.cours.clientleger.Model.Database.Internautes;
import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;

public class InternautesValidatorIsSet {
    public static boolean isSet(Internautes internautes) {
        boolean isSet = true;
        if (internautes.getNom().equals("")) {
            isSet = false;
        } else if (internautes.getPrenom().equals("")) {
            isSet = false;
        } else if (internautes.getCivilite() != 1 && internautes.getCivilite() != 2) {
            isSet = false;
        } else if (internautes.getDate_naissance().equals(LocalDate.now())) {
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
        return isSet;
    }
}
