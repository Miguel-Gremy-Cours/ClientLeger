package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.StudioEntity;

import org.springframework.data.repository.CrudRepository;

public interface StudiosRepository extends CrudRepository<StudioEntity, Integer> {
}
