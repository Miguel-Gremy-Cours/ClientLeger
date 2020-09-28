package com.cours.clientleger.Model.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Civilite {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String libelle;


  public long getId() {
    return id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

}
