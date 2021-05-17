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
@Table(name = "Offre", schema = "dbo", catalog = "MegaCasting")
public class OffreEntity {
    private int id;
    private int idStudio;
    private String intitule;
    private int idMetier;
    private Date datePublication;
    private int dureDiffusion;
    private int nombrePostes;
    private String descriptionPoste;
    private String descriptionProfile;
    private int idEmploye;
    private String localisation;
    private String codeOffre;
    private Collection<ContratEntity> contratsById;
    private StudioEntity studioByIdStudio;
    private MetierEntity metierByIdMetier;
    private EmployeEntity employeByIdEmploye;
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
    @Column(name = "IdStudio")
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    @Basic
    @Column(name = "Intitule")
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Basic
    @Column(name = "IdMetier")
    public int getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(int idMetier) {
        this.idMetier = idMetier;
    }

    @Basic
    @Column(name = "DatePublication")
    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @Basic
    @Column(name = "DureDiffusion")
    public int getDureDiffusion() {
        return dureDiffusion;
    }

    public void setDureDiffusion(int dureDiffusion) {
        this.dureDiffusion = dureDiffusion;
    }

    @Basic
    @Column(name = "NombrePostes")
    public int getNombrePostes() {
        return nombrePostes;
    }

    public void setNombrePostes(int nombrePostes) {
        this.nombrePostes = nombrePostes;
    }

    @Basic
    @Column(name = "DescriptionPoste")
    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public void setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
    }

    @Basic
    @Column(name = "DescriptionProfile")
    public String getDescriptionProfile() {
        return descriptionProfile;
    }

    public void setDescriptionProfile(String descriptionProfile) {
        this.descriptionProfile = descriptionProfile;
    }

    @Basic
    @Column(name = "IdEmploye")
    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "Localisation")
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Basic
    @Column(name = "CodeOffre")
    public String getCodeOffre() {
        return codeOffre;
    }

    public void setCodeOffre(String codeOffre) {
        this.codeOffre = codeOffre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffreEntity that = (OffreEntity) o;

        if (id != that.id) return false;
        if (idStudio != that.idStudio) return false;
        if (idMetier != that.idMetier) return false;
        if (dureDiffusion != that.dureDiffusion) return false;
        if (nombrePostes != that.nombrePostes) return false;
        if (idEmploye != that.idEmploye) return false;
        if (intitule != null ? !intitule.equals(that.intitule) : that.intitule != null)
            return false;
        if (datePublication != null ? !datePublication.equals(that.datePublication) : that.datePublication != null)
            return false;
        if (descriptionPoste != null ? !descriptionPoste.equals(that.descriptionPoste) : that.descriptionPoste != null)
            return false;
        if (descriptionProfile != null ? !descriptionProfile.equals(that.descriptionProfile) : that.descriptionProfile != null)
            return false;
        if (localisation != null ? !localisation.equals(that.localisation) : that.localisation != null)
            return false;
        if (codeOffre != null ? !codeOffre.equals(that.codeOffre) : that.codeOffre != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idStudio;
        result = 31 * result + (intitule != null ? intitule.hashCode() : 0);
        result = 31 * result + idMetier;
        result = 31 * result + (datePublication != null ? datePublication.hashCode() : 0);
        result = 31 * result + dureDiffusion;
        result = 31 * result + nombrePostes;
        result = 31 * result + (descriptionPoste != null ? descriptionPoste.hashCode() : 0);
        result = 31 * result + (descriptionProfile != null ? descriptionProfile.hashCode() : 0);
        result = 31 * result + idEmploye;
        result = 31 * result + (localisation != null ? localisation.hashCode() : 0);
        result = 31 * result + (codeOffre != null ? codeOffre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "offreByIdOffre")
    public Collection<ContratEntity> getContratsById() {
        return contratsById;
    }

    public void setContratsById(Collection<ContratEntity> contratsById) {
        this.contratsById = contratsById;
    }

    @ManyToOne
    @JoinColumn(name = "IdStudio", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public StudioEntity getStudioByIdStudio() {
        return studioByIdStudio;
    }

    public void setStudioByIdStudio(StudioEntity studioByIdStudio) {
        this.studioByIdStudio = studioByIdStudio;
    }

    @ManyToOne
    @JoinColumn(name = "IdMetier", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public MetierEntity getMetierByIdMetier() {
        return metierByIdMetier;
    }

    public void setMetierByIdMetier(MetierEntity metierByIdMetier) {
        this.metierByIdMetier = metierByIdMetier;
    }

    @ManyToOne
    @JoinColumn(name = "IdEmploye", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public EmployeEntity getEmployeByIdEmploye() {
        return employeByIdEmploye;
    }

    public void setEmployeByIdEmploye(EmployeEntity employeByIdEmploye) {
        this.employeByIdEmploye = employeByIdEmploye;
    }

    @OneToMany(mappedBy = "offreByIdOffre")
    public Collection<OffresInternauteEntity> getOffresInternautesById() {
        return offresInternautesById;
    }

    public void setOffresInternautesById(Collection<OffresInternauteEntity> offresInternautesById) {
        this.offresInternautesById = offresInternautesById;
    }
}
