package com.cours.clientleger.Model.Database;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;


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


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
