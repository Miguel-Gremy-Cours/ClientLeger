package com.cours.clientleger.Model.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long studio;
    private String intitule;
    private long metier;
    private long contrat;
    private java.sql.Date publication;
    private long dureDiffusion;
    private long nombrePostes;
    private String descriptionPoste;
    private String desciptionProfile;
    private long numeroEmploye;
    private String localisation;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getStudio() {
        return studio;
    }

    public void setStudio(long studio) {
        this.studio = studio;
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    public long getMetier() {
        return metier;
    }

    public void setMetier(long metier) {
        this.metier = metier;
    }


    public long getContrat() {
        return contrat;
    }

    public void setContrat(long contrat) {
        this.contrat = contrat;
    }


    public java.sql.Date getPublication() {
        return publication;
    }

    public void setPublication(java.sql.Date publication) {
        this.publication = publication;
    }


    public long getDureDiffusion() {
        return dureDiffusion;
    }

    public void setDureDiffusion(long dureDiffusion) {
        this.dureDiffusion = dureDiffusion;
    }


    public long getNombrePostes() {
        return nombrePostes;
    }

    public void setNombrePostes(long nombrePostes) {
        this.nombrePostes = nombrePostes;
    }


    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public void setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
    }


    public String getDesciptionProfile() {
        return desciptionProfile;
    }

    public void setDesciptionProfile(String desciptionProfile) {
        this.desciptionProfile = desciptionProfile;
    }


    public long getNumeroEmploye() {
        return numeroEmploye;
    }

    public void setNumeroEmploye(long numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }


    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

}
