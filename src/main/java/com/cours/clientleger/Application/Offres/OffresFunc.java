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
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    OffresRepository offresRepository;
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    OffresInternautesRepository offresInternautesRepository;

    /**
     * Function called when getting all offers
     *
     * @return List of offers, null if empty
     */
    public List<OffreEntity> getOffres() {
        return (List<OffreEntity>) offresRepository.findAll();
    }

    /**
     * Function called when getting one offer
     *
     * @param id of the offer
     * @return the offer, null not found
     */
    public OffreEntity getOffre(int id) {
        return offresRepository.getById(id);
    }

    /**
     * Function called to postulate to an offer
     *
     * @param httpSession user session
     * @param idOffre id of wanted offer
     * @return if the action was a success or not
     */
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

    /**
     * Function called when searching offer by name or description
     *
     * @param searchString content to search into offers
     * @return list of offers containing input string, null if empty
     */
    public List<OffreEntity> search(String searchString) {
        List<OffreEntity> offres = new ArrayList<>();
        //noinspection ConstantConditions
        if (searchString.isEmpty() || searchString == null || searchString.equals("all")) {
            offres = getOffres();
        } else {
            offres.addAll(offresRepository.findAllByDescriptionPosteContains(searchString));
            offres.addAll(offresRepository.findAllByIntituleContains(searchString));
        }
        return offres.stream().distinct().collect(Collectors.toList());
    }
}
