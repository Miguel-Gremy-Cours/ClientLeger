package com.cours.clientleger.Model.Database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "civilite")
    private long civilite;
    @Column(name = "groupe_employes")
    private long groupe_employes;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

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


    public long getCivilite() {
        return civilite;
    }

    public void setCivilite(long civilite) {
        this.civilite = civilite;
    }


    public long getGroupe_employes() {
        return groupe_employes;
    }

    public void setGroupe_employes(long groupeEmployes) {
        this.groupe_employes = groupeEmployes;
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

    //endregion

}
