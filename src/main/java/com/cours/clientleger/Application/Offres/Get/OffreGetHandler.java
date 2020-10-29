package com.cours.clientleger.Application.Offres.Get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class OffreGetHandler {
    @Autowired
    OffreGetInstance offreGetInstance;

    public Boolean GetOffresList(HttpSession httpSession) {
        httpSession.setAttribute("offresList", offreGetInstance.GetOffresList());

        return true;
    }
}
