package com.cours.clientleger.Model.DatabaseEntities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contrat", schema = "dbo", catalog = "MegaCasting")
public class ContratEntity {
    private int id;
    private int idTypeContrat;
    private Date debutContrat;
    private int dureContrat;
    private String codeContrat;
    private String fichierContrat;
    private int idOffre;
    private TypeContratEntity typeContratByIdTypeContrat;
    private OffreEntity offreByIdOffre;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdTypeContrat")
    public int getIdTypeContrat() {
        return idTypeContrat;
    }

    public void setIdTypeContrat(int idTypeContrat) {
        this.idTypeContrat = idTypeContrat;
    }

    @Basic
    @Column(name = "DebutContrat")
    public Date getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(Date debutContrat) {
        this.debutContrat = debutContrat;
    }

    @Basic
    @Column(name = "DureContrat")
    public int getDureContrat() {
        return dureContrat;
    }

    public void setDureContrat(int dureContrat) {
        this.dureContrat = dureContrat;
    }

    @Basic
    @Column(name = "CodeContrat")
    public String getCodeContrat() {
        return codeContrat;
    }

    public void setCodeContrat(String codeContrat) {
        this.codeContrat = codeContrat;
    }

    @Basic
    @Column(name = "FichierContrat")
    public String getFichierContrat() {
        return fichierContrat;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }

    @Basic
    @Column(name = "IdOffre")
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContratEntity that = (ContratEntity) o;

        if (id != that.id) return false;
        if (idTypeContrat != that.idTypeContrat) return false;
        if (dureContrat != that.dureContrat) return false;
        if (idOffre != that.idOffre) return false;
        if (debutContrat != null ? !debutContrat.equals(that.debutContrat) : that.debutContrat != null)
            return false;
        if (codeContrat != null ? !codeContrat.equals(that.codeContrat) : that.codeContrat != null)
            return false;
        if (fichierContrat != null ? !fichierContrat.equals(that.fichierContrat) : that.fichierContrat != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idTypeContrat;
        result = 31 * result + (debutContrat != null ? debutContrat.hashCode() : 0);
        result = 31 * result + dureContrat;
        result = 31 * result + (codeContrat != null ? codeContrat.hashCode() : 0);
        result = 31 * result + (fichierContrat != null ? fichierContrat.hashCode() : 0);
        result = 31 * result + idOffre;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdTypeContrat", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public TypeContratEntity getTypeContratByIdTypeContrat() {
        return typeContratByIdTypeContrat;
    }

    public void setTypeContratByIdTypeContrat(TypeContratEntity typeContratByIdTypeContrat) {
        this.typeContratByIdTypeContrat = typeContratByIdTypeContrat;
    }

    @ManyToOne
    @JoinColumn(name = "IdOffre", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public OffreEntity getOffreByIdOffre() {
        return offreByIdOffre;
    }

    public void setOffreByIdOffre(OffreEntity offreByIdOffre) {
        this.offreByIdOffre = offreByIdOffre;
    }
}
