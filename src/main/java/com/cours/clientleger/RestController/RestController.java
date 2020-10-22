package com.cours.clientleger.RestController;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.Database.Offre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    OffresRepository offresRepository;

    private Iterable<Offre> offreIterable;

    @GetMapping
    public Iterable<Offre> restOffre() {
        Thread threadOffreAll = new Thread(() -> {
            offreIterable = offresRepository.findAll();
        });
        threadOffreAll.start();
        try {
            threadOffreAll.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return offreIterable;
    }
}
