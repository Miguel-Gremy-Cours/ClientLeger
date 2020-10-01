package com.cours.clientleger.Model.AccessingDataJPA;

import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.data.repository.CrudRepository;

public interface InternautesRepository extends CrudRepository<Internautes, Long> {
    Internautes getByLoginAndPassword(String login, String password);

    Boolean existsByLoginAndPassword(String login, String password);

}
