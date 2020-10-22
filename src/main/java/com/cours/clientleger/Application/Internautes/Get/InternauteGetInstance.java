package com.cours.clientleger.Application.Internautes.Get;

import com.cours.clientleger.Application.Internautes.InternauteExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.Database.Internaute;
import com.google.common.hash.Hashing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.cours.clientleger.Application.Internautes.Validator.InternauteValidatorIsEmpty.isEmpty;

@Component
public class InternauteGetInstance {
    @Autowired
    InternauteRepository internauteRepository;

    public Internaute GetInternautes(Map<String, String> data) throws Exception {
        if (isEmpty(data)) {
            throw new Exception(InternauteExceptionEnum.DATA_EMPTY.getFName());
        } else {
            return internauteRepository.getByLoginAndPassword(data.get("login"),
                    Hashing.sha256().hashString(data.get("password"), StandardCharsets.UTF_8).toString());
        }
    }
}