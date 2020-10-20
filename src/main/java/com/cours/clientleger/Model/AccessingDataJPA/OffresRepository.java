package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Offre;

import org.springframework.data.repository.CrudRepository;

public interface OffresRepository extends CrudRepository<Offre, Long> {
    Offre getById(long id);
}
