package com.cours.clientleger.Model.Database;


import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "IdTypeContrat")
    private long idTypeContrat;
    @Column(name = "DebutContrat")
    private java.sql.Date debutContrat;
    @Column(name = "DureContrat")
    private long dureContrat;
    @Column(name = "CodeContrat")
    private String codeContrat;
    @Column(name = "FichierContrat")
    private String fichierContrat;
    @Column(name = "IdOffre")
    private long idOffre;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getIdTypeContrat() {
        return idTypeContrat;
    }

    public void setIdTypeContrat(long idTypeContrat) {
        this.idTypeContrat = idTypeContrat;
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


    public String getCodeContrat() {
        return codeContrat;
    }

    public void setCodeContrat(String codeContrat) {
        this.codeContrat = codeContrat;
    }


    public String getFichierContrat() {
        return fichierContrat;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }


    public long getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(long idOffre) {
        this.idOffre = idOffre;
    }

}
