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
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdStudio", nullable = false)
    public int getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(int idStudio) {
        this.idStudio = idStudio;
    }

    @Basic
    @Column(name = "Intitule", nullable = false, length = 25)
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Basic
    @Column(name = "IdMetier", nullable = false)
    public int getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(int idMetier) {
        this.idMetier = idMetier;
    }

    @Basic
    @Column(name = "DatePublication", nullable = false)
    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @Basic
    @Column(name = "DureDiffusion", nullable = false)
    public int getDureDiffusion() {
        return dureDiffusion;
    }

    public void setDureDiffusion(int dureDiffusion) {
        this.dureDiffusion = dureDiffusion;
    }

    @Basic
    @Column(name = "NombrePostes", nullable = false)
    public int getNombrePostes() {
        return nombrePostes;
    }

    public void setNombrePostes(int nombrePostes) {
        this.nombrePostes = nombrePostes;
    }

    @Basic
    @Column(name = "DescriptionPoste", nullable = false, length = 100)
    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public void setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
    }

    @Basic
    @Column(name = "DescriptionProfile", nullable = false, length = 100)
    public String getDescriptionProfile() {
        return descriptionProfile;
    }

    public void setDescriptionProfile(String descriptionProfile) {
        this.descriptionProfile = descriptionProfile;
    }

    @Basic
    @Column(name = "IdEmploye", nullable = false)
    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "Localisation", nullable = false, length = 50)
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Basic
    @Column(name = "CodeOffre", nullable = false, length = 50)
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
        return id == that.id &&
                idStudio == that.idStudio &&
                idMetier == that.idMetier &&
                dureDiffusion == that.dureDiffusion &&
                nombrePostes == that.nombrePostes &&
                idEmploye == that.idEmploye &&
                Objects.equals(intitule, that.intitule) &&
                Objects.equals(datePublication, that.datePublication) &&
                Objects.equals(descriptionPoste, that.descriptionPoste) &&
                Objects.equals(descriptionProfile, that.descriptionProfile) &&
                Objects.equals(localisation, that.localisation) &&
                Objects.equals(codeOffre, that.codeOffre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStudio, intitule, idMetier, datePublication, dureDiffusion, nombrePostes, descriptionPoste, descriptionProfile, idEmploye, localisation, codeOffre);
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
