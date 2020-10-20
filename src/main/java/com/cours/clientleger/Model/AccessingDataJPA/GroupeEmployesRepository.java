package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.GroupeEmploye;

import org.springframework.data.repository.CrudRepository;

public interface GroupeEmployesRepository extends CrudRepository<GroupeEmploye, Integer> {
}
