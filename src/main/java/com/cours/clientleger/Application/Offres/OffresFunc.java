package com.cours.clientleger.Application.Offres;

import com.cours.clientleger.Model.AccessingDataJPA.OffresInternautesRepository;
import com.cours.clientleger.Model.AccessingDataJPA.OffresRepository;
import com.cours.clientleger.Model.DatabaseEntities.OffreEntity;
import com.cours.clientleger.Model.DatabaseEntities.OffresInternauteEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

@Component
public class OffresFunc {
    @Autowired
    OffresRepository offresRepository;
    @Autowired
    OffresInternautesRepository offresInternautesRepository;

    public List<OffreEntity> getOffres() {
        return (List<OffreEntity>) offresRepository.findAll();
    }

    public OffreEntity getOffre(int id) {
        return offresRepository.getById(id);
    }

    public boolean createOffreInternaute(HttpSession httpSession, int idOffre) {
        int idInternaute = Integer.parseInt(httpSession.getAttribute("id").toString());
        boolean out = true;
        if (!offresInternautesRepository.existsByIdInternauteAndIdOffre(idInternaute, idOffre)) {
            OffresInternauteEntity offresInternauteEntity = new OffresInternauteEntity();
            offresInternauteEntity.setIdInternaute(idInternaute);
            offresInternauteEntity.setIdOffre(idOffre);
            offresInternauteEntity.setDatePostulation(new Date(Calendar.getInstance().getTime().getTime()));
            offresInternautesRepository.save(offresInternauteEntity);
        } else {
            out = false;
        }
        return out;
    }

    public List<OffreEntity> search(String searchString) {
        List<OffreEntity> offres = new ArrayList<>();
        if (searchString.isEmpty() || searchString == null || searchString.equals("all")) {
            offres = getOffres();
        } else {
            offres.addAll(offresRepository.findAllByDescriptionPosteContains(searchString));
            offres.addAll(offresRepository.findAllByIntituleContains(searchString));
        }
        return offres.stream().distinct().collect(Collectors.toList());
    }
}
