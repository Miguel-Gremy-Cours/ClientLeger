package com.cours.clientleger.Utils;

import com.cours.clientleger.Application.Internautes.InternautesValidatorGetProblem;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;
import static com.cours.clientleger.Application.Internautes.InternautesValidatorIsSet.*;

@Component
public class DatabaseUtils {
    @Autowired
    InternautesRepository internautesRepository;

    public Internautes insertInDatabase(Map<String, String> data, HttpSession httpSession) {
        Internautes internautes = null;
        if (!data.isEmpty()) {
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            internautes = new Internautes(
                    data.get("nom"),
                    data.get("prenom"),
                    stringToLocalDate(data.get("date_naissance")),
                    civilite,
                    null,
                    data.get("login"),
                    String.valueOf(data.get("password").hashCode()),
                    null,
                    data.get("email")
            );
        }
        if (isSet(internautes)) {
            internautesRepository.save(internautes);
            httpSession.setAttribute("Internautes", internautes);
        } else {
            List<String> problems = InternautesValidatorGetProblem.getProblem(internautes);
            httpSession.setAttribute("problems", problems);
            internautes = null;
        }
        return internautes;
    }

    public Internautes updateInDatabase(Map<String, String> data, HttpSession httpSession) {
        Internautes internautes = (Internautes) httpSession.getAttribute("Internautes");
        if (!data.isEmpty()) {
            int civilite = 0;
            if (data.get("civility").equals("male")) {
                civilite = 1;
            } else if (data.get("civility").equals("female")) {
                civilite = 2;
            }
            internautes.setNom(data.get("nom"));
            internautes.setPrenom(data.get("prenom"));
            internautes.setDate_naissance(stringToLocalDate(data.get("date_naissance")));
            internautes.setCivilite(civilite);
            internautes.setLien_google(null);
            internautes.setLogin(data.get("login"));
            internautes.setPassword(String.valueOf(data.get("password").hashCode()));
            internautes.setCv_name(null);
            internautes.setEmail(data.get("email"));
        }
        if (isSet(internautes)) {
            internautesRepository.save(internautes);
            httpSession.setAttribute("Internautes", internautes);
        } else {
            List<String> problems = InternautesValidatorGetProblem.getProblem(internautes);
            httpSession.setAttribute("problems", problems);
            internautes = null;
        }
        return internautes;
    }
}
