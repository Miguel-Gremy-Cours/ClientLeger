package com.cours.clientleger.Application.Offres.Get;

import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.DatabaseEntities.OffreEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OffreGetInstance {
    @Autowired
    OffresRepository offresRepository;

    /**
     * Function that get the required Offre from database
     *
     * @param Id Id of the required offre
     * @return The offres Object (OffreEntity)
     */
    public OffreEntity GetOffre(int Id) {
        return offresRepository.getById(Id);
    }

    /**
     * Function that get all the Offres from database
     *
     * @return the list of Offres in database
     */
    public List<OffreEntity> GetOffresList() {
        return (List<OffreEntity>) offresRepository.findAll();
    }

}
