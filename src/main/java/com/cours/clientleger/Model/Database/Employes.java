package com.cours.clientleger.Model.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private long civilite;
    private long groupeEmployes;
    private String login;
    private String password;


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


    public long getCivilite() {
        return civilite;
    }

    public void setCivilite(long civilite) {
        this.civilite = civilite;
    }


    public long getGroupeEmployes() {
        return groupeEmployes;
    }

    public void setGroupeEmployes(long groupeEmployes) {
        this.groupeEmployes = groupeEmployes;
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
