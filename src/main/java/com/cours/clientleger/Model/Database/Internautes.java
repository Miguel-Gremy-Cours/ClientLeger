package com.cours.clientleger.Model.Database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Internautes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    @Column(name = "datenaissance")
    private java.sql.Date dateNaissance;
    @Column(name = "dateinscription")
    private java.sql.Date dateInscription;
    private long civilite;
    @Column(name = "liengoogle")
    private String lienGoogle;
    private String login;
    private String password;
    @Column(name = "cvname")
    private String CvName;
    private String email;


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
        return CvName;
    }

    public void setCvName(String cvName) {
        this.CvName = cvName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return
                "id : " + this.id +
                        " | nom : " + this.nom +
                        " | prenom : " + this.prenom +
                        " | Civilite : " + this.civilite +
                        " | dateNaissance : " + this.dateNaissance +
                        " | email : " + this.email +
                        " | dateInscription : " + this.dateInscription +
                        " | CvName : " + this.CvName +
                        " | lienGoogle : " + this.lienGoogle +
                        " | login : " + this.login +
                        " | password : " + this.password;
    }

}
