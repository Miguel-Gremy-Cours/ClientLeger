package com.cours.clientleger.Model.DatabaseEntities;

import java.sql.Date;
import java.util.Objects;

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
    @Column(name = "IdInternaute", nullable = false)
    public int getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(int idInternaute) {
        this.idInternaute = idInternaute;
    }

    @Id
    @Column(name = "IdOffre", nullable = false)
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Basic
    @Column(name = "DatePostulation", nullable = false)
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
        return idInternaute == that.idInternaute &&
                idOffre == that.idOffre &&
                Objects.equals(datePostulation, that.datePostulation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInternaute, idOffre, datePostulation);
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