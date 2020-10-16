package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternautesExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;
import com.google.common.hash.Hashing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
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
            return internautesRepository.getByLoginAndPassword(data.get("login"),
                    Hashing.sha256().hashString(data.get("password"), StandardCharsets.UTF_8).toString());
        }
    }
}
