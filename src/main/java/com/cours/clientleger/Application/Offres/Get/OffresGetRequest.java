package com.cours.clientleger.Application.Offres.Get;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OffresGetRequest {
    @Autowired
    OffresGetInstance offresGetInstance;
    @Autowired
    OffresGetResponse offresGetResponse;
    
}
