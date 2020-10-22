package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.OffreEntity;

import org.springframework.data.repository.CrudRepository;

public interface OffresRepository extends CrudRepository<OffreEntity, Long> {
    OffreEntity getById(long id);
}
