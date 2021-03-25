package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.CiviliteEntity;

import org.springframework.data.repository.CrudRepository;

public interface CiviliteRepository extends CrudRepository<CiviliteEntity, Integer> {
    CiviliteEntity findById(int id);
}
