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
    private Integer id;
    private Date debutContrat;
    private Integer dureContrat;
    private String codeContrat;
    private String fichierContrat;
    private TypeContratEntity typeContratByIdTypeContrat;
    private OffreEntity offreByIdOffre;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Integer getDureContrat() {
        return dureContrat;
    }

    public void setDureContrat(Integer dureContrat) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratEntity that = (ContratEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(debutContrat, that.debutContrat) && Objects.equals(dureContrat, that.dureContrat) && Objects.equals(codeContrat, that.codeContrat) && Objects.equals(fichierContrat, that.fichierContrat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debutContrat, dureContrat, codeContrat, fichierContrat);
    }

    @ManyToOne
    @JoinColumn(name = "IdTypeContrat", referencedColumnName = "Id", nullable = false)
    public TypeContratEntity getTypeContratByIdTypeContrat() {
        return typeContratByIdTypeContrat;
    }

    public void setTypeContratByIdTypeContrat(TypeContratEntity typeContratByIdTypeContrat) {
        this.typeContratByIdTypeContrat = typeContratByIdTypeContrat;
    }

    @ManyToOne
    @JoinColumn(name = "IdOffre", referencedColumnName = "Id", nullable = false)
    public OffreEntity getOffreByIdOffre() {
        return offreByIdOffre;
    }

    public void setOffreByIdOffre(OffreEntity offreByIdOffre) {
        this.offreByIdOffre = offreByIdOffre;
    }
}
