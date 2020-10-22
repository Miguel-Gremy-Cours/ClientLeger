package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.ContratEntity;

import org.springframework.data.repository.CrudRepository;

public interface ContratRepository extends CrudRepository<ContratEntity, Integer> {
}
