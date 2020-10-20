package com.cours.clientleger.Model.Database;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "IdCivilite")
    private long idCivilite;
    @Column(name = "IdGroupeEmployes")
    private long idGroupeEmployes;
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


    public long getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(long idCivilite) {
        this.idCivilite = idCivilite;
    }


    public long getIdGroupeEmployes() {
        return idGroupeEmployes;
    }

    public void setIdGroupeEmployes(long idGroupeEmployes) {
        this.idGroupeEmployes = idGroupeEmployes;
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
