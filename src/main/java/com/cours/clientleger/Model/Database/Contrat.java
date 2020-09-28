package com.cours.clientleger.Model.Database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long typeContrat;
    private java.sql.Date debutContrat;
    private long dureContrat;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(long typeContrat) {
        this.typeContrat = typeContrat;
    }


    public java.sql.Date getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(java.sql.Date debutContrat) {
        this.debutContrat = debutContrat;
    }


    public long getDureContrat() {
        return dureContrat;
    }

    public void setDureContrat(long dureContrat) {
        this.dureContrat = dureContrat;
    }

}
