package com.cours.clientleger.Model.Database;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OffresInternautes.class)
public class OffresInternautes implements Serializable {

    @Id
    @Column(name = "id_internaute")
    private long id_internaute;
    @Id
    @Column(name = "id_offre")
    private long id_offre;
    @Column(name = "date_postulation")
    private LocalDate datePostulation;

    //region Getters Setters

    public long getId_internaute() {
        return id_internaute;
    }

    public void setId_internaute(long idInternaute) {
        this.id_internaute = idInternaute;
    }


    public long getId_offre() {
        return id_offre;
    }

    public void setId_offre(long idOffre) {
        this.id_offre = idOffre;
    }


    public LocalDate getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(LocalDate datePostulation) {
        this.datePostulation = datePostulation;
    }

    //endregion

}
