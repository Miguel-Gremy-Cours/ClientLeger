package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.EmployeEntity;

import org.springframework.data.repository.CrudRepository;

public interface EmployesRepository extends CrudRepository<EmployeEntity, Integer> {
}
