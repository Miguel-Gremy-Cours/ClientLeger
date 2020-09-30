package com.cours.clientleger.Model.Database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Metier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "domaine_metier")
    private long domaine_metier;

    //region Getters Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public long getDomaine_metier() {
        return domaine_metier;
    }

    public void setDomaine_metier(long domaineMetier) {
        this.domaine_metier = domaineMetier;
    }

    //endregion

}
