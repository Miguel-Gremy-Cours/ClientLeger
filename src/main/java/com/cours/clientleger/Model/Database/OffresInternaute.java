package com.cours.clientleger.Model.Database;


import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class OffresInternaute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInternaute;
    @Column(name = "IdOffre")
    private long idOffre;
    @Column(name = "DatePostulation")
    private LocalDate datePostulation;


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


    public LocalDate getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(LocalDate datePostulation) {
        this.datePostulation = datePostulation;
    }

}
