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
@Table(name = "Employe", schema = "dbo", catalog = "MegaCasting")
public class EmployeEntity {
    private int id;
    private String nom;
    private String prenom;
    private int idCivilite;
    private int idGroupeEmployes;
    private String login;
    private String password;
    private CiviliteEntity civiliteByIdCivilite;
    private GroupeEmployeEntity groupeEmployeByIdGroupeEmployes;
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
    @Column(name = "Nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "IdCivilite")
    public int getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(int idCivilite) {
        this.idCivilite = idCivilite;
    }

    @Basic
    @Column(name = "IdGroupeEmployes")
    public int getIdGroupeEmployes() {
        return idGroupeEmployes;
    }

    public void setIdGroupeEmployes(int idGroupeEmployes) {
        this.idGroupeEmployes = idGroupeEmployes;
    }

    @Basic
    @Column(name = "Login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeEntity that = (EmployeEntity) o;

        if (id != that.id) return false;
        if (idCivilite != that.idCivilite) return false;
        if (idGroupeEmployes != that.idGroupeEmployes) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + idCivilite;
        result = 31 * result + idGroupeEmployes;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdCivilite", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public CiviliteEntity getCiviliteByIdCivilite() {
        return civiliteByIdCivilite;
    }

    public void setCiviliteByIdCivilite(CiviliteEntity civiliteByIdCivilite) {
        this.civiliteByIdCivilite = civiliteByIdCivilite;
    }

    @ManyToOne
    @JoinColumn(name = "IdGroupeEmployes", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public GroupeEmployeEntity getGroupeEmployeByIdGroupeEmployes() {
        return groupeEmployeByIdGroupeEmployes;
    }

    public void setGroupeEmployeByIdGroupeEmployes(GroupeEmployeEntity groupeEmployeByIdGroupeEmployes) {
        this.groupeEmployeByIdGroupeEmployes = groupeEmployeByIdGroupeEmployes;
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<OffreEntity> getOffresById() {
        return offresById;
    }

    public void setOffresById(Collection<OffreEntity> offresById) {
        this.offresById = offresById;
    }
}
