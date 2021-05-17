package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.OffreEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffresRepository extends JpaRepository<OffreEntity, Integer> {
    OffreEntity getById(int id);

    List<OffreEntity> findAllByIntituleContains(String searchString);

    List<OffreEntity> findAllByDescriptionPosteContains(String searchString);
}
