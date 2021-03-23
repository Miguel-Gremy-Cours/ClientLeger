package com.cours.clientleger.RestController;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.AccessingDataJPA.PartenairesRepository;
import com.cours.clientleger.Model.Rest.RestOffre;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    @Autowired
    OffresRepository offresRepository;
    @Autowired
    PartenairesRepository partenairesRepository;

    // List that will be send by the API
    private final List<RestOffre> offres = new ArrayList<>();

    /**
     * API controller that send Offres at the URL : /api
     *
     * @param credentials credentials from the request
     * @return List of RestOffre of all offres in database
     */
    @PostMapping
    public List<RestOffre> restOffre(@RequestBody String credentials) {
        if (checkLoginPassword(credentials)) {
            // Clear the List to avoid the duplicates due to multiple calls
            offres.clear();
            /**
             * Do threaded operation to avoid the WebApp to be block if there are many Offres in database
             * Or bad connection
             */
            Thread threadOffreAll = new Thread(() -> offresRepository.findAll().forEach(
                    offreEntity -> offres.add(
                            /**
                             * Creation of the RestOffre object for all Offres in database
                             * And change filds from Identifier to Libelle
                             */
                            new RestOffre()
                                    .setId(offreEntity.getId())
                                    .setStudio(offreEntity.getStudioByIdStudio().getLibelle())
                                    .setIntitule(offreEntity.getIntitule())
                                    .setMetier(offreEntity.getMetierByIdMetier().getLibelle())
                                    .setDatePublication(offreEntity.getDatePublication())
                                    .setDureDiffusion(offreEntity.getDureDiffusion())
                                    .setNombrePostes(offreEntity.getNombrePostes())
                                    .setDescriptionPoste(offreEntity.getDescriptionPoste())
                                    .setDescriptionProfile(offreEntity.getDescriptionProfile())
                                    .setEmploye(offreEntity.getEmployeByIdEmploye().getNom())
                                    .setLocalisation(offreEntity.getLocalisation())
                                    .setCodeOffre(offreEntity.getCodeOffre())
                    )
            ));
            // Start the threaded operation
            threadOffreAll.start();
            try {
                // Wait for the threaded operation to be finished
                threadOffreAll.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Throws an 400 Http error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return offres;
    }

    /**
     * API function that check if partenaire is log correctly
     *
     * @param credentials credentials from the request
     * @return Boolean if login or not
     */
    private boolean checkLoginPassword(String credentials) {
        // Try to parse from web to string variable
        try {
            // Parse from web to Json without beginning of request
            credentials = URLDecoder.decode(credentials.substring(credentials.indexOf('=') + 1),
                    StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getCause());
        }
        JsonObject credentialsJson = new Gson().fromJson(credentials, JsonElement.class).getAsJsonObject();
        // Return if partenaire exists in database
        return partenairesRepository.existsByLoginAndPassword(
                credentialsJson.get("login").toString().replace("\"", ""),
                credentialsJson.get("password").toString().replace("\"", "")
        );
    }

}
