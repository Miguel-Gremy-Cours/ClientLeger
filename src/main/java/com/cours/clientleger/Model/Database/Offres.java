package com.cours.clientleger.Model.Database;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Offres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "studio")
    private long studio;
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "metier")
    private long metier;
    @Column(name = "contrat")
    private long contrat;
    @Column(name = "date_publication")
    private LocalDate date_publication;
    @Column(name = "dure_diffusion")
    private long dure_diffusion;
    @Column(name = "nombre_postes")
    private long nombre_postes;
    @Column(name = "description_poste")
    private String description_poste;
    @Column(name = "description_profile")
    private String description_profile;
    @Column(name = "numero_employe")
    private long numero_employe;
    @Column(name = "localisation")
    private String localisation;

    //region Getters Setters

    public long getId() {
        return id;
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


    public LocalDate getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(LocalDate publication) {
        this.date_publication = publication;
    }


    public long getDure_diffusion() {
        return dure_diffusion;
    }

    public void setDure_diffusion(long dureDiffusion) {
        this.dure_diffusion = dureDiffusion;
    }


    public long getNombre_postes() {
        return nombre_postes;
    }

    public void setNombre_postes(long nombrePostes) {
        this.nombre_postes = nombrePostes;
    }


    public String getDescription_poste() {
        return description_poste;
    }

    public void setDescription_poste(String descriptionPoste) {
        this.description_poste = descriptionPoste;
    }


    public String getDescription_profile() {
        return description_profile;
    }

    public void setDescription_profile(String desciptionProfile) {
        this.description_profile = desciptionProfile;
    }


    public long getNumero_employe() {
        return numero_employe;
    }

    public void setNumero_employe(long numeroEmploye) {
        this.numero_employe = numeroEmploye;
    }


    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    //endregion

}
