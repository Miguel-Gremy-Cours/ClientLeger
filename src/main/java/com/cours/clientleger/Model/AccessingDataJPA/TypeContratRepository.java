package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.TypeContratEntity;

import org.springframework.data.repository.CrudRepository;

public interface TypeContratRepository extends CrudRepository<TypeContratEntity, Integer> {
}
