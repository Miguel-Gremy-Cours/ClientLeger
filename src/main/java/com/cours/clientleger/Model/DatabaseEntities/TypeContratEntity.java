package com.cours.clientleger.Model.DatabaseEntities;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TypeContrat", schema = "dbo", catalog = "MegaCasting")
public class TypeContratEntity {
    private int id;
    private String libelle;
    private Collection<ContratEntity> contratsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeContratEntity that = (TypeContratEntity) o;

        if (id != that.id) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeContratByIdTypeContrat")
    public Collection<ContratEntity> getContratsById() {
        return contratsById;
    }

    public void setContratsById(Collection<ContratEntity> contratsById) {
        this.contratsById = contratsById;
    }
}
