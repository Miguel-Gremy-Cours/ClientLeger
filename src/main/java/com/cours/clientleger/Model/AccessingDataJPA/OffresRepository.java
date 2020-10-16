package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Offres;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffresRepository extends CrudRepository<Offres, Long> {
    Offres getById(long id);
}
