package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Employe;

import org.springframework.data.repository.CrudRepository;

public interface EmployesRepository extends CrudRepository<Employe, Integer> {
}
