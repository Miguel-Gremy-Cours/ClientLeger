package com.cours.clientleger.Model.Database;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Studios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "siret")
    private String siret;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "numero_adresse")
    private long numero_adresse;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;

    //region Getters Setters

    public long getId() {
        return id;
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


    public long getNumero_adresse() {
        return numero_adresse;
    }

    public void setNumero_adresse(long numero_adresse) {
        this.numero_adresse = numero_adresse;
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

    //endregion

}
