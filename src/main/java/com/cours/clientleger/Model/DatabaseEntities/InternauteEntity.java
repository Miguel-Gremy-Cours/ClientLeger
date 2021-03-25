package com.cours.clientleger.Model.DatabaseEntities;

import java.sql.Date;
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
@Table(name = "Internaute", schema = "dbo", catalog = "MegaCasting")
public class InternauteEntity {
    private Integer id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateInscription;
    private String lienGoogle;
    private String login;
    private String password;
    private String cv;
    private String email;
    private CiviliteEntity civiliteByIdCivilite;
    private Collection<OffresInternauteEntity> offresInternautesById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "DateNaissance", nullable = false)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "DateInscription", nullable = false)
    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Basic
    @Column(name = "LienGoogle", nullable = true, length = 200)
    public String getLienGoogle() {
        return lienGoogle;
    }

    public void setLienGoogle(String lienGoogle) {
        this.lienGoogle = lienGoogle;
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
    @Column(name = "Password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Cv", nullable = true, length = 2147483647)
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 254)
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
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(dateNaissance, that.dateNaissance) && Objects.equals(dateInscription, that.dateInscription) && Objects.equals(lienGoogle, that.lienGoogle) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(cv, that.cv) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, dateNaissance, dateInscription, lienGoogle, login, password, cv, email);
    }

    @ManyToOne
    @JoinColumn(name = "IdCivilite", referencedColumnName = "Id", nullable = false)
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
