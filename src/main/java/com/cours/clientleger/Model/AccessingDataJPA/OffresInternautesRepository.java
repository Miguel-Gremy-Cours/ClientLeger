package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.OffresInternauteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffresInternautesRepository extends JpaRepository<OffresInternauteEntity, Integer> {
    boolean existsByIdInternauteAndIdOffre(int idInternaute, int idOffre);
}
