package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.DomaineMetier;

import org.springframework.data.repository.CrudRepository;

public interface DomaineMetierRepository extends CrudRepository<DomaineMetier, Integer> {
}
