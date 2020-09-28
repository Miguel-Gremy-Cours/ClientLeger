package com.cours.clientleger.Model.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Internautes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private java.sql.Date dateNaissance;
    private java.sql.Date dateInscription;
    private long civilite;
    private String lienGoogle;
    private String login;
    private String password;
    private String cvName;
    private String email;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public java.sql.Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public java.sql.Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(java.sql.Date dateInscription) {
        this.dateInscription = dateInscription;
    }


    public long getCivilite() {
        return civilite;
    }

    public void setCivilite(long civilite) {
        this.civilite = civilite;
    }


    public String getLienGoogle() {
        return lienGoogle;
    }

    public void setLienGoogle(String lienGoogle) {
        this.lienGoogle = lienGoogle;
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


    public String getCvName() {
        return cvName;
    }

    public void setCvName(String cvName) {
        this.cvName = cvName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
