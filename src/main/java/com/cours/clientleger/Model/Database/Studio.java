package com.cours.clientleger.Model.Database;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Siret")
    private String siret;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "NumeroAdresse")
    private long numeroAdresse;
    @Column(name = "Libelle")
    private String libelle;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telephone")
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
