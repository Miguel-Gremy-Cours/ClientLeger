package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Employes;

import org.springframework.data.repository.CrudRepository;

public interface EmployesRepository extends CrudRepository<Employes, Integer> {
}
