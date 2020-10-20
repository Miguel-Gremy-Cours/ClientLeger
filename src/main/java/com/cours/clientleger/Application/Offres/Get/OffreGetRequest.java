package com.cours.clientleger.Application.Offres.Get;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OffreGetRequest {
    @Autowired
    OffreGetInstance offreGetInstance;
    @Autowired
    OffreGetResponse offreGetResponse;
    
}
