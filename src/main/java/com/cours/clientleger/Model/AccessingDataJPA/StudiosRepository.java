package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Studio;

import org.springframework.data.repository.CrudRepository;

public interface StudiosRepository extends CrudRepository<Studio, Integer> {
}
