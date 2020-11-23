package com.cours.clientleger.Model.Rest;


import java.sql.Date;

/**
 * This class is needed for the API to send the values of fields
 * Instead of Identifier
 */
public class RestOffre {
    private int id;
    private String studio;
    private String intitule;
    private String metier;
    private Date datePublication;
    private int dureDiffusion;
    private int nombrePostes;
    private String descriptionPoste;
    private String descriptionProfile;
    private String employe;
    private String localisation;
    private String codeOffre;

    public int getId() {
        return id;
    }

    public RestOffre setId(int id) {
        this.id = id;
        return this;
    }

    public String getStudio() {
        return studio;
    }

    public RestOffre setStudio(String studio) {
        this.studio = studio;
        return this;
    }

    public String getIntitule() {
        return intitule;
    }

    public RestOffre setIntitule(String intitule) {
        this.intitule = intitule;
        return this;
    }

    public String getMetier() {
        return metier;
    }

    public RestOffre setMetier(String metier) {
        this.metier = metier;
        return this;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public RestOffre setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
        return this;
    }

    public int getDureDiffusion() {
        return dureDiffusion;
    }

    public RestOffre setDureDiffusion(int dureDiffusion) {
        this.dureDiffusion = dureDiffusion;
        return this;
    }

    public int getNombrePostes() {
        return nombrePostes;
    }

    public RestOffre setNombrePostes(int nombrePostes) {
        this.nombrePostes = nombrePostes;
        return this;
    }

    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public RestOffre setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
        return this;
    }

    public String getDescriptionProfile() {
        return descriptionProfile;
    }

    public RestOffre setDescriptionProfile(String descriptionProfile) {
        this.descriptionProfile = descriptionProfile;
        return this;
    }

    public String getEmploye() {
        return employe;
    }

    public RestOffre setEmploye(String employe) {
        this.employe = employe;
        return this;
    }

    public String getLocalisation() {
        return localisation;
    }

    public RestOffre setLocalisation(String localisation) {
        this.localisation = localisation;
        return this;
    }

    public String getCodeOffre() {
        return codeOffre;
    }

    public RestOffre setCodeOffre(String codeOffre) {
        this.codeOffre = codeOffre;
        return this;
    }
}
