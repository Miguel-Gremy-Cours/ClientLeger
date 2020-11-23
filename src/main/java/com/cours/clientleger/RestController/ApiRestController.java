package com.cours.clientleger.RestController;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.Rest.RestOffre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    @Autowired
    OffresRepository offresRepository;

    // List that will be send by the API
    private final List<RestOffre> offres = new ArrayList<>();

    /**
     * API controller that send Offres at the URL : /api
     *
     * @return List<RestOffre> of all offres in database
     */
    @GetMapping
    public Iterable<RestOffre> restOffre() {
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
        return offres;
    }
}
