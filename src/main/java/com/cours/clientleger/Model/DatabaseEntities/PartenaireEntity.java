package com.cours.clientleger.Model.DatabaseEntities;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Partenaire", schema = "dbo", catalog = "MegaCasting")
public class PartenaireEntity {
    private Integer id;
    private String siret;
    private String adresse;
    private Integer numeroAdresse;
    private String libelle;
    private String email;
    private String telephone;
    private String login;
    private String password;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Integer getNumeroAdresse() {
        return numeroAdresse;
    }

    public void setNumeroAdresse(Integer numeroAdresse) {
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
    @Column(name = "Email", nullable = false, length = 25)
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
        PartenaireEntity that = (PartenaireEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(siret, that.siret) && Objects.equals(adresse, that.adresse) && Objects.equals(numeroAdresse, that.numeroAdresse) && Objects.equals(libelle, that.libelle) && Objects.equals(email, that.email) && Objects.equals(telephone, that.telephone) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siret, adresse, numeroAdresse, libelle, email, telephone, login, password);
    }
}
