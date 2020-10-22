package com.cours.clientleger.Model.DatabaseEntities;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdTypeContrat", nullable = false)
    public int getIdTypeContrat() {
        return idTypeContrat;
    }

    public void setIdTypeContrat(int idTypeContrat) {
        this.idTypeContrat = idTypeContrat;
    }

    @Basic
    @Column(name = "DebutContrat", nullable = false)
    public Date getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(Date debutContrat) {
        this.debutContrat = debutContrat;
    }

    @Basic
    @Column(name = "DureContrat", nullable = false)
    public int getDureContrat() {
        return dureContrat;
    }

    public void setDureContrat(int dureContrat) {
        this.dureContrat = dureContrat;
    }

    @Basic
    @Column(name = "CodeContrat", nullable = false, length = 50)
    public String getCodeContrat() {
        return codeContrat;
    }

    public void setCodeContrat(String codeContrat) {
        this.codeContrat = codeContrat;
    }

    @Basic
    @Column(name = "FichierContrat", nullable = false, length = 2147483647)
    public String getFichierContrat() {
        return fichierContrat;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }

    @Basic
    @Column(name = "IdOffre", nullable = false)
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
        return id == that.id &&
                idTypeContrat == that.idTypeContrat &&
                dureContrat == that.dureContrat &&
                idOffre == that.idOffre &&
                Objects.equals(debutContrat, that.debutContrat) &&
                Objects.equals(codeContrat, that.codeContrat) &&
                Objects.equals(fichierContrat, that.fichierContrat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTypeContrat, debutContrat, dureContrat, codeContrat, fichierContrat, idOffre);
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
