package com.cours.clientleger.Controller.Utils;

import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;
import com.cours.clientleger.Model.Enum.ProblemEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.Utils.DateUtils.stringToLocalDate;
import static java.util.Objects.isNull;

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
        if (internautes.isSet()) {
            internautesRepository.save(internautes);
            httpSession.setAttribute("Internautes", internautes);
        } else {
            List<String> problems = internautes.getProblem();
            httpSession.setAttribute("problems", problems);
            internautes = null;
        }
        return internautes;
    }
}
