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
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nom", nullable = false, length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom", nullable = false, length = 50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "IdCivilite", nullable = false)
    public int getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(int idCivilite) {
        this.idCivilite = idCivilite;
    }

    @Basic
    @Column(name = "IdGroupeEmployes", nullable = false)
    public int getIdGroupeEmployes() {
        return idGroupeEmployes;
    }

    public void setIdGroupeEmployes(int idGroupeEmployes) {
        this.idGroupeEmployes = idGroupeEmployes;
    }

    @Basic
    @Column(name = "Login", nullable = false, length = 100)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 200)
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
        return id == that.id &&
                idCivilite == that.idCivilite &&
                idGroupeEmployes == that.idGroupeEmployes &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, idCivilite, idGroupeEmployes, login, password);
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
