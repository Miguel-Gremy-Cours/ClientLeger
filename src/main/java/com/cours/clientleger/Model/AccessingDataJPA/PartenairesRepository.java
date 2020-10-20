package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Partenaire;

import org.springframework.data.repository.CrudRepository;

public interface PartenairesRepository extends CrudRepository<Partenaire, Integer> {
}
