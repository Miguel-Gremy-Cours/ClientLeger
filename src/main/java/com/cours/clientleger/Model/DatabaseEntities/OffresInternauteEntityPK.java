package com.cours.clientleger.Model.DatabaseEntities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;

public class OffresInternauteEntityPK implements Serializable {
    private int idInternaute;
    private int idOffre;

    @Column(name = "IdInternaute", nullable = false)
    @Id
    public int getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(int idInternaute) {
        this.idInternaute = idInternaute;
    }

    @Column(name = "IdOffre", nullable = false)
    @Id
    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffresInternauteEntityPK that = (OffresInternauteEntityPK) o;
        return idInternaute == that.idInternaute &&
                idOffre == that.idOffre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInternaute, idOffre);
    }
}