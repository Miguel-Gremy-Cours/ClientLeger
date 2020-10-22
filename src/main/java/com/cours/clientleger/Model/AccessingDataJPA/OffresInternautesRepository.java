package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.OffresInternauteEntity;

import org.springframework.data.repository.CrudRepository;

public interface OffresInternautesRepository extends CrudRepository<OffresInternauteEntity, Integer> {
}
