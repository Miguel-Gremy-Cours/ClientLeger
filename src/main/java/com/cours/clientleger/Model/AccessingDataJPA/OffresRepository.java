package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Offres;

import org.springframework.data.repository.CrudRepository;

public interface OffresRepository extends CrudRepository<Offres, Integer> {
}
