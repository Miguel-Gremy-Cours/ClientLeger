package com.cours.clientleger.Model.DatabaseEntities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Libelle", nullable = false, length = 50)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "IdDomaineMetier", nullable = false)
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
        return id == that.id &&
                idDomaineMetier == that.idDomaineMetier &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, idDomaineMetier);
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