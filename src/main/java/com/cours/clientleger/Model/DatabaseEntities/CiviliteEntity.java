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
@Table(name = "Civilite", schema = "dbo", catalog = "MegaCasting")
public class CiviliteEntity {
    private Integer id;
    private String libelle;
    private Collection<EmployeEntity> employesById;
    private Collection<InternauteEntity> internautesById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Libelle", nullable = false, length = 4)
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
        return Objects.equals(id, that.id) && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
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
