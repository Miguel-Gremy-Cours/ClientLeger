package com.cours.clientleger.Model.DatabaseEntities;

import java.sql.Date;
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
@Table(name = "Internaute", schema = "dbo", catalog = "MegaCasting")
public class InternauteEntity {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateInscription;
    private int idCivilite;
    private String lienGoogle;
    private String login;
    private String password;
    private String cv;
    private String email;
    private CiviliteEntity civiliteByIdCivilite;
    private Collection<OffresInternauteEntity> offresInternautesById;

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
    @Column(name = "DateNaissance")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "DateInscription")
    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
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
    @Column(name = "LienGoogle")
    public String getLienGoogle() {
        return lienGoogle;
    }

    public void setLienGoogle(String lienGoogle) {
        this.lienGoogle = lienGoogle;
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

    @Basic
    @Column(name = "Cv")
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InternauteEntity that = (InternauteEntity) o;

        if (id != that.id) return false;
        if (idCivilite != that.idCivilite) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (dateNaissance != null ? !dateNaissance.equals(that.dateNaissance) : that.dateNaissance != null)
            return false;
        if (dateInscription != null ? !dateInscription.equals(that.dateInscription) : that.dateInscription != null)
            return false;
        if (lienGoogle != null ? !lienGoogle.equals(that.lienGoogle) : that.lienGoogle != null)
            return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (cv != null ? !cv.equals(that.cv) : that.cv != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (dateNaissance != null ? dateNaissance.hashCode() : 0);
        result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
        result = 31 * result + idCivilite;
        result = 31 * result + (lienGoogle != null ? lienGoogle.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cv != null ? cv.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
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

    @OneToMany(mappedBy = "internauteByIdInternaute")
    public Collection<OffresInternauteEntity> getOffresInternautesById() {
        return offresInternautesById;
    }

    public void setOffresInternautesById(Collection<OffresInternauteEntity> offresInternautesById) {
        this.offresInternautesById = offresInternautesById;
    }
}
