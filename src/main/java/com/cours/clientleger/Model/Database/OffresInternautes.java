package com.cours.clientleger.Model.Database;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OffresInternautes.class)
public class OffresInternautes implements Serializable {

    @Id
    private long idInternaute;
    @Id
    private long idOffre;
    private java.sql.Date datePostulation;


    public long getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(long idInternaute) {
        this.idInternaute = idInternaute;
    }


    public long getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(long idOffre) {
        this.idOffre = idOffre;
    }


    public java.sql.Date getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(java.sql.Date datePostulation) {
        this.datePostulation = datePostulation;
    }

}
