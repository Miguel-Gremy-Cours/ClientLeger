package com.cours.clientleger.Model.DatabaseEntities;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Metier", schema = "dbo", catalog = "MegaCasting")
public class MetierEntity {
    private int id;
    private String libelle;
    private int idDomaineMetier;
    private DomaineMetierEntity domaineMetierByIdDomaineMetier;
    private Collection<OffreEntity> offresById;

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
    @Column(name = "Libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "IdDomaineMetier")
    public int getIdDomaineMetier() {
        return idDomaineMetier;
    }

    public void setIdDomaineMetier(int idDomaineMetier) {
        this.idDomaineMetier = idDomaineMetier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetierEntity that = (MetierEntity) o;

        if (id != that.id) return false;
        if (idDomaineMetier != that.idDomaineMetier) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + idDomaineMetier;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdDomaineMetier", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public DomaineMetierEntity getDomaineMetierByIdDomaineMetier() {
        return domaineMetierByIdDomaineMetier;
    }

    public void setDomaineMetierByIdDomaineMetier(DomaineMetierEntity domaineMetierByIdDomaineMetier) {
        this.domaineMetierByIdDomaineMetier = domaineMetierByIdDomaineMetier;
    }

    @OneToMany(mappedBy = "metierByIdMetier")
    public Collection<OffreEntity> getOffresById() {
        return offresById;
    }

    public void setOffresById(Collection<OffreEntity> offresById) {
        this.offresById = offresById;
    }
}
