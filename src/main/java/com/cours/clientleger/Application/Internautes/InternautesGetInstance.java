package com.cours.clientleger.Application.Internautes;

import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternautesValidatorIsEmpty.isEmpty;

@Component
public class InternautesGetInstance {
    @Autowired
    InternautesRepository internautesRepository;

    public Internautes GetInternautes(Map<String, String> data) throws Exception {
        if (isEmpty(data)) {
            throw new Exception(InternautesExceptionEnum.DATA_EMPTY.getFName());
        } else {
            return internautesRepository.getByLoginAndPassword(data.get("login"), String.valueOf(data.get("password").hashCode()));
        }
    }
}
