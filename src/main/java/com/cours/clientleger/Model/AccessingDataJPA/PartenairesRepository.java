package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.PartenaireEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartenairesRepository extends JpaRepository<PartenaireEntity, Integer> {
    boolean existsByLoginAndPassword(String Login, String Password);
}
