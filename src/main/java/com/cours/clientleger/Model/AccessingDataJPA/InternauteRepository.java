package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;

import org.springframework.data.repository.CrudRepository;

public interface InternauteRepository extends CrudRepository<InternauteEntity, Long> {
    InternauteEntity getByLoginAndPassword(String login, String password);

    InternauteEntity getById(int id);

    Boolean existsByLoginAndPassword(String login, String password);

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);

}
