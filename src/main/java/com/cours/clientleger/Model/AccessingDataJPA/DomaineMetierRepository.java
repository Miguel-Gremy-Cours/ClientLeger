package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.DomaineMetierEntity;

import org.springframework.data.repository.CrudRepository;

public interface DomaineMetierRepository extends CrudRepository<DomaineMetierEntity, Integer> {
}
