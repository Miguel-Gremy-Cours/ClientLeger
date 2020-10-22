package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.PartenaireEntity;

import org.springframework.data.repository.CrudRepository;

public interface PartenairesRepository extends CrudRepository<PartenaireEntity, Integer> {
}
