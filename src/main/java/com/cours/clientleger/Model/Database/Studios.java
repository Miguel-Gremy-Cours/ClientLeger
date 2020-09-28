package com.cours.clientleger.Model.Database;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Studios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String siret;
    private String adresse;
    private long numeroAdresse;
    private String libelle;
    private String email;
    private String telephone;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public long getNumeroAdresse() {
        return numeroAdresse;
    }

    public void setNumeroAdresse(long numeroAdresse) {
        this.numeroAdresse = numeroAdresse;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
