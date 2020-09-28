package com.cours.clientleger.Model.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Metier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String libelle;
    private long domaineMetier;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public long getDomaineMetier() {
        return domaineMetier;
    }

    public void setDomaineMetier(long domaineMetier) {
        this.domaineMetier = domaineMetier;
    }

}
