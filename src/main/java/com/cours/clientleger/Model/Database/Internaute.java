package com.cours.clientleger.Model.Database;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.relational.core.mapping.Table;


@Entity(name = "Internaute")
@Table
public class Internaute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "DateNaissance")
    private LocalDate dateNaissance;
    @Column(name = "DateInscription")
    private LocalDate dateInscription;
    @Column(name = "IdCivilite")
    private long idCivilite;
    @Column(name = "LienGoogle")
    private String lienGoogle;
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;
    @Column(name = "Cv")
    private String cv;
    @Column(name = "Email")
    private String email;


    public Internaute(
            String nom,
            String prenom,
            LocalDate dateNaissance,
            long civilite,
            String lienGoogle,
            String login,
            String password,
            String cv,
            String email
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateInscription = LocalDate.now();
        this.idCivilite = civilite;
        this.lienGoogle = lienGoogle;
        this.login = login;
        this.password = password;
        this.cv = cv;
        this.email = email;
    }

    public Internaute() {
    }


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


    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }


    public long getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(long idCivilite) {
        this.idCivilite = idCivilite;
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


    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toString() {
        return
                "id : " + this.id +
                        " | nom : " + this.nom +
                        " | prenom : " + this.prenom +
                        " | Civilite : " + this.idCivilite +
                        " | dateNaissance : " + this.dateNaissance +
                        " | email : " + this.email +
                        " | dateInscription : " + this.dateInscription +
                        " | CvName : " + this.cv +
                        " | lienGoogle : " + this.lienGoogle +
                        " | login : " + this.login +
                        " | password : " + this.password;
    }

}
