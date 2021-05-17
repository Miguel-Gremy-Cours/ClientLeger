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
@Table(name = "Civilite", schema = "dbo", catalog = "MegaCasting")
public class CiviliteEntity {
    private int id;
    private String libelle;
    private Collection<EmployeEntity> employesById;
    private Collection<InternauteEntity> internautesById;

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

        CiviliteEntity that = (CiviliteEntity) o;

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

    @OneToMany(mappedBy = "civiliteByIdCivilite")
    public Collection<EmployeEntity> getEmployesById() {
        return employesById;
    }

    public void setEmployesById(Collection<EmployeEntity> employesById) {
        this.employesById = employesById;
    }

    @OneToMany(mappedBy = "civiliteByIdCivilite")
    public Collection<InternauteEntity> getInternautesById() {
        return internautesById;
    }

    public void setInternautesById(Collection<InternauteEntity> internautesById) {
        this.internautesById = internautesById;
    }
}
