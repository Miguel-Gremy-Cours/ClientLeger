package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.OffreEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffresRepository extends CrudRepository<OffreEntity, Integer> {
    OffreEntity getById(int id);

    List<OffreEntity> findAllByIntituleContains(String searchString);

    List<OffreEntity> findAllByDescriptionPosteContains(String searchString);
}
