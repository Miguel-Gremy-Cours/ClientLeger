package com.cours.clientleger.Model.Database;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "type_contrat")
    private long type_contrat;
    @Column(name = "debut_contrat")
    private LocalDate debut_contrat;
    @Column(name = "dure_contrat")
    private long dure_contrat;

    //region Getters Setters

    public void setId(long id) {
        this.id = id;
    }


    public long getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(long typeContrat) {
        this.type_contrat = typeContrat;
    }


    public LocalDate getDebut_contrat() {
        return debut_contrat;
    }

    public void setDebut_contrat(LocalDate debutContrat) {
        this.debut_contrat = debutContrat;
    }


    public long getDure_contrat() {
        return dure_contrat;
    }

    public void setDure_contrat(long dureContrat) {
        this.dure_contrat = dureContrat;
    }

    //endregion
}
