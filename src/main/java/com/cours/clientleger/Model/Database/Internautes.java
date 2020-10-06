package com.cours.clientleger.Model.Database;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Internautes {

    public Internautes(
            String nom,
            String prenom,
            LocalDate date_naissance,
            long civilite,
            String lien_google,
            String login,
            String password,
            String cv_name,
            String email
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.date_inscription = LocalDate.now();
        this.civilite = civilite;
        this.lien_google = lien_google;
        this.login = login;
        this.password = password;
        this.cv_name = cv_name;
        this.email = email;
    }

    public Internautes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "date_naissance")
    private LocalDate date_naissance;
    @Column(name = "date_inscription")
    private LocalDate date_inscription;
    @Column(name = "civilite")
    private long civilite;
    @Column(name = "lien_google")
    private String lien_google;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "cv_name")
    private String cv_name;
    @Column(name = "email")
    private String email;

    //region Getters Setters

    public long getId() {
        return id;
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


    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate dateNaissance) {
        this.date_naissance = dateNaissance;
    }


    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate dateInscription) {
        this.date_inscription = dateInscription;
    }


    public long getCivilite() {
        return civilite;
    }

    public void setCivilite(long civilite) {
        this.civilite = civilite;
    }


    public String getLien_google() {
        return lien_google;
    }

    public void setLien_google(String lienGoogle) {
        this.lien_google = lienGoogle;
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


    public String getCv_name() {
        return cv_name;
    }

    public void setCv_name(String cv_name) {
        this.cv_name = cv_name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //endregion

    @Override
    public String toString() {
        return
                "id : " + this.id +
                        " | nom : " + this.nom +
                        " | prenom : " + this.prenom +
                        " | Civilite : " + this.civilite +
                        " | dateNaissance : " + this.date_naissance +
                        " | email : " + this.email +
                        " | dateInscription : " + this.date_inscription +
                        " | CvName : " + this.cv_name +
                        " | lienGoogle : " + this.lien_google +
                        " | login : " + this.login +
                        " | password : " + this.password;
    }
}
