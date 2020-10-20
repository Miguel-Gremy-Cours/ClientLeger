package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Internaute;

import org.springframework.data.repository.CrudRepository;

public interface InternauteRepository extends CrudRepository<Internaute, Long> {
    Internaute getByLoginAndPassword(String login, String password);

    Boolean existsByLoginAndPassword(String login, String password);

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);

}
