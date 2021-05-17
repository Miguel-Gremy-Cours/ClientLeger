package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternauteRepository extends JpaRepository<InternauteEntity, Integer> {
    InternauteEntity getByLoginAndPassword(String login, String password);

    InternauteEntity getById(int id);

    Boolean existsByLoginAndPassword(String login, String password);

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);

}
