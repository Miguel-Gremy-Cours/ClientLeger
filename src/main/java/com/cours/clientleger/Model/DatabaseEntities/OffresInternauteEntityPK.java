package com.cours.clientleger.Model.DatabaseEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class OffresInternauteEntityPK implements Serializable {
    private int idInternaute;
    private int idOffre;

    @Column(name = "IdInternaute")
    @Id
    public int getIdInternaute() {
        return idInternaute;
    }

    public void setIdInternaute(int idInternaute) {
        this.idInternaute = idInternaute;
    }

    @Column(name = "IdOffre")
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

        if (idInternaute != that.idInternaute) return false;
        if (idOffre != that.idOffre) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInternaute;
        result = 31 * result + idOffre;
        return result;
    }
}
