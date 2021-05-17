package com.cours.clientleger.Application.Internautes;

import com.cours.clientleger.Model.AccessingDataJPA.CiviliteRepository;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;
import com.google.common.hash.Hashing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsEmpty.isEmpty;
import static com.cours.clientleger.Utils.DateUtils.stringToLocalDate;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Component
public class InternauteFunc {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    InternauteRepository internauteRepository;
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    CiviliteRepository civiliteRepository;

    /**
     * function called when user log-out
     *
     * @param httpSession user session
     */
    public void logOut(HttpSession httpSession) {
        httpSession.removeAttribute("data");
        httpSession.removeAttribute("isLoged");
    }

    /**
     * Function called when creating a new internaute database
     *
     * @param internauteMap return from the view
     * @throws Exception field is empty or doesn't have the right format (ex: date)
     */
    public void create(Map<String, String> internauteMap) throws Exception {
        if (!isEmpty(internauteMap)) {
            InternauteEntity internaute = createInternaute(internauteMap, -1);
            internauteRepository.save(internaute);
        } else {
            throw new Exception("Invalid input");
        }
    }

    /**
     * function called when updating a new internaute
     *
     * @param internauteMap return from the view
     * @param httpSession   user session
     * @throws Exception field is empty or doesn't have the right format (ex: date)
     */
    public void update(Map<String, String> internauteMap, HttpSession httpSession) throws Exception {
        if (!isEmpty(internauteMap)) {
            InternauteEntity internaute = createInternaute(internauteMap, Integer.parseInt(httpSession.getAttribute("id").toString()));
            internauteRepository.save(internaute);
        } else {
            throw new Exception("Invalid input");
        }
    }

    /**
     * function called when getting an internaute from the database
     *
     * @param login    login of internaute
     * @param password password of internaute
     * @return the internaute in database, null if doesn't exists
     */
    public InternauteEntity get(String login, String password) {
        return internauteRepository.getByLoginAndPassword(login, hashFunc(password));
    }

    /**
     * function called when getting an internaute from the database
     *
     * @param id id of internaute
     * @return the internaute in database, null if doesn't exists
     */
    public InternauteEntity get(int id) {
        return internauteRepository.getById(id);
    }

    /**
     * return sha256 hash of the string
     *
     * @param input string to be hash
     * @return the hashed string
     */
    @SuppressWarnings("UnstableApiUsage")
    private String hashFunc(String input) {
        return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
    }

    /**
     * function called when creating a new internaute (not database)
     *
     * @param internauteMap informations of the internaute (ex return from the view)
     * @param id            id of the user, if -1, internaute's id stay empty,
     *                      otherwise, get password from database with the id
     * @return the internaute created
     */
    private InternauteEntity createInternaute(Map<String, String> internauteMap, int id) {
        InternauteEntity internaute = new InternauteEntity();
        internaute.setIdCivilite(internauteMap.get("civility").equals("male") ? 1 : 2);
        internaute.setNom(internauteMap.get("nom"));
        internaute.setPrenom(internauteMap.get("prenom"));
        internaute.setDateNaissance(Date.valueOf(stringToLocalDate(internauteMap.get("date_naissance"))));
        internaute.setDateInscription(new Date(Calendar.getInstance().getTime().getTime()));
        internaute.setLienGoogle(null);
        internaute.setLogin(internauteMap.get("login"));
        if (id == -1) {
            internaute.setPassword(hashFunc(internauteMap.get("password")));
        } else {
            internaute.setPassword(internauteRepository.getById(id).getPassword());
            internaute.setId(id);
        }
        internaute.setCv(null);
        internaute.setEmail(internauteMap.get("email"));

        return internaute;
    }

}
