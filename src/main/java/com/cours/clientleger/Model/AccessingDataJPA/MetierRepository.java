package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Metier;

import org.springframework.data.repository.CrudRepository;

public interface MetierRepository extends CrudRepository<Metier, Integer> {
}
