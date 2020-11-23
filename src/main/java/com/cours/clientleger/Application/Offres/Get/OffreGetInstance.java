package com.cours.clientleger.Application.Offres.Get;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.DatabaseEntities.OffreEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OffreGetInstance {
    @Autowired
    OffresRepository offresRepository;

    public OffreEntity GetOffre(int Id) {
        return offresRepository.getById(Id);
    }

    public List<OffreEntity> GetOffresList() {
        return (List<OffreEntity>) offresRepository.findAll();
    }

}
