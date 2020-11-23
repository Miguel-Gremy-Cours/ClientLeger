package com.cours.clientleger.Application.Offres.Get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class OffreGetHandler {
    @Autowired
    OffreGetInstance offreGetInstance;

    /**
     * Function to all offres from database
     *
     * @param httpSession Data in Http session
     * @return If getting all Offres in database finidhed or tthere was errors
     */
    public Boolean GetOffresList(HttpSession httpSession) {
        httpSession.setAttribute("offresList", offreGetInstance.GetOffresList());

        return true;
    }

    /**
     * Function to get one Offre from database
     *
     * @param Id          Id of the Offre wanted
     * @param httpSession Data in Http session
     * @return If getting an offre from database finished or there was errors
     */
    public Boolean GetOffre(int Id, HttpSession httpSession) {
        httpSession.setAttribute("offre", offreGetInstance.GetOffre(Id));

        return true;
    }
}
