package com.cours.clientleger.Model.DatabaseEntities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DomaineMetier", schema = "dbo", catalog = "MegaCasting")
public class DomaineMetierEntity {
    private int id;
    private String libelle;
    private Collection<MetierEntity> metiersById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomaineMetierEntity that = (DomaineMetierEntity) o;
        return id == that.id &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }

    @OneToMany(mappedBy = "domaineMetierByIdDomaineMetier")
    public Collection<MetierEntity> getMetiersById() {
        return metiersById;
    }

    public void setMetiersById(Collection<MetierEntity> metiersById) {
        this.metiersById = metiersById;
    }
}
