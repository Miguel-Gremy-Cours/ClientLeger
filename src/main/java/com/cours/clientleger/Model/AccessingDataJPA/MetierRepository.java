package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.MetierEntity;

import org.springframework.data.repository.CrudRepository;

public interface MetierRepository extends CrudRepository<MetierEntity, Integer> {
}
