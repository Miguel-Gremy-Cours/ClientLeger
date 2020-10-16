package com.cours.clientleger.Application.Offres.Get;

import com.cours.clientleger.Application.Offres.PostsExceptionEnum;
import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.Database.Offres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.cours.clientleger.Application.Offres.Validator.OffresValidatorIsEmpty.isEmpty;

@Component
public class OffresGetInstance {
    @Autowired
    OffresRepository offresRepository;

    public Offres GetOffres(Map<String, String> data) throws Exception {
        if (isEmpty(data)) {
            throw new Exception(PostsExceptionEnum.ID_EMPTY.getFName());
        } else {
            return offresRepository.getById(Integer.parseInt(data.get("id")));
        }
    }

    public List<Offres> GetOffresList() {
        return (List<Offres>) offresRepository.findAll();
    }

}
