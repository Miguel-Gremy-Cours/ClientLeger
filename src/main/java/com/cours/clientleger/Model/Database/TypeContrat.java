package com.cours.clientleger.Model.Database;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class TypeContrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String libelle;


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

}
