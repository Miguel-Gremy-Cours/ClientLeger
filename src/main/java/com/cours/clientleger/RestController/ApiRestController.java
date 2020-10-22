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

    private final List<RestOffre> offres = new ArrayList<>();

    @GetMapping
    public Iterable<RestOffre> restOffre() {
        offres.clear();
        Thread threadOffreAll = new Thread(() -> offresRepository.findAll().forEach(
                offreEntity -> offres.add(
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
        threadOffreAll.start();
        try {
            threadOffreAll.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return offres;
    }
}
