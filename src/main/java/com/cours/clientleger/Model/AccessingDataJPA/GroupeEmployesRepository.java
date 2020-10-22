package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.GroupeEmployeEntity;

import org.springframework.data.repository.CrudRepository;

public interface GroupeEmployesRepository extends CrudRepository<GroupeEmployeEntity, Integer> {
}
