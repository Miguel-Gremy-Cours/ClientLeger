package com.cours.clientleger.Model.Database;


import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "IdStudio")
    private long idStudio;
    @Column(name = "Intitule")
    private String intitule;
    @Column(name = "IdMetier")
    private long idMetier;
    @Column(name = "DatePublication")
    private LocalDate datePublication;
    @Column(name = "DureDiffusion")
    private long dureDiffusion;
    @Column(name = "NombrePostes")
    private long nombrePostes;
    @Column(name = "DescriptionPoste")
    private String descriptionPoste;
    @Column(name = "DescriptionProfile")
    private String descriptionProfile;
    @Column(name = "IdEmploye")
    private long idEmploye;
    @Column(name = "Localisation")
    private String localisation;
    @Column(name = "codeOffre")
    private String codeOffre;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(long idStudio) {
        this.idStudio = idStudio;
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    public long getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(long idMetier) {
        this.idMetier = idMetier;
    }


    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
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


    public String getDescriptionProfile() {
        return descriptionProfile;
    }

    public void setDescriptionProfile(String descriptionProfile) {
        this.descriptionProfile = descriptionProfile;
    }


    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }


    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }


    public String getCodeOffre() {
        return codeOffre;
    }

    public void setCodeOffre(String codeOffre) {
        this.codeOffre = codeOffre;
    }

}
