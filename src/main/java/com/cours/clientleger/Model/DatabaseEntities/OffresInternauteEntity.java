package com.cours.clientleger.Model.DatabaseEntities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OffresInternaute", schema = "dbo", catalog = "MegaCasting")
@IdClass(OffresInternauteEntityPK.class)
public class OffresInternauteEntity {
    private int idInternaute;
    private int idOffre;
    private Date datePostulation;
    private InternauteEntity internauteByIdInternaute;
    private OffreEntity offreByIdOffre;

    @Id
    @Column(name = "IdInternaute")
    public int getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(int idInternaute) {
        this.idInternaute = idInternaute;
    }

    @Id
    @Column(name = "IdOffre")
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Basic
    @Column(name = "DatePostulation")
    public Date getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(Date datePostulation) {
        this.datePostulation = datePostulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffresInternauteEntity that = (OffresInternauteEntity) o;

        if (idInternaute != that.idInternaute) return false;
        if (idOffre != that.idOffre) return false;
        if (datePostulation != null ? !datePostulation.equals(that.datePostulation) : that.datePostulation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInternaute;
        result = 31 * result + idOffre;
        result = 31 * result + (datePostulation != null ? datePostulation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdInternaute", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public InternauteEntity getInternauteByIdInternaute() {
        return internauteByIdInternaute;
    }

    public void setInternauteByIdInternaute(InternauteEntity internauteByIdInternaute) {
        this.internauteByIdInternaute = internauteByIdInternaute;
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
