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
@Table(name = "Studio", schema = "dbo", catalog = "MegaCasting")
public class StudioEntity {
    private int id;
    private String siret;
    private String adresse;
    private int numeroAdresse;
    private String libelle;
    private String email;
    private String telephone;
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
    @Column(name = "Siret", nullable = false, length = 100)
    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Basic
    @Column(name = "Adresse", nullable = false, length = 25)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "NumeroAdresse", nullable = false)
    public int getNumeroAdresse() {
        return numeroAdresse;
    }

    public void setNumeroAdresse(int numeroAdresse) {
        this.numeroAdresse = numeroAdresse;
    }

    @Basic
    @Column(name = "Libelle", nullable = false, length = 25)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 254)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Telephone", nullable = false, length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudioEntity that = (StudioEntity) o;
        return id == that.id &&
                numeroAdresse == that.numeroAdresse &&
                Objects.equals(siret, that.siret) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(libelle, that.libelle) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siret, adresse, numeroAdresse, libelle, email, telephone);
    }

    @OneToMany(mappedBy = "studioByIdStudio")
    public Collection<OffreEntity> getOffresById() {
        return offresById;
    }

    public void setOffresById(Collection<OffreEntity> offresById) {
        this.offresById = offresById;
    }
}
