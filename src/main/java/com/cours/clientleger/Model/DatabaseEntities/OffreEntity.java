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
    private Integer id;
    private String intitule;
    private Date datePublication;
    private Integer dureDiffusion;
    private Integer nombrePostes;
    private String descriptionPoste;
    private String descriptionProfile;
    private String localisation;
    private String codeOffre;
    private MetierEntity metierByIdMetier;
    private EmployeEntity employeByIdEmploye;
    private Collection<ContratEntity> contratsById;
    private StudioEntity studioByIdStudio;
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
    @Column(name = "Intitule", nullable = false, length = 25)
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
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
    public Integer getDureDiffusion() {
        return dureDiffusion;
    }

    public void setDureDiffusion(Integer dureDiffusion) {
        this.dureDiffusion = dureDiffusion;
    }

    @Basic
    @Column(name = "NombrePostes", nullable = false)
    public Integer getNombrePostes() {
        return nombrePostes;
    }

    public void setNombrePostes(Integer nombrePostes) {
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
        return Objects.equals(id, that.id) && Objects.equals(intitule, that.intitule) && Objects.equals(datePublication, that.datePublication) && Objects.equals(dureDiffusion, that.dureDiffusion) && Objects.equals(nombrePostes, that.nombrePostes) && Objects.equals(descriptionPoste, that.descriptionPoste) && Objects.equals(descriptionProfile, that.descriptionProfile) && Objects.equals(localisation, that.localisation) && Objects.equals(codeOffre, that.codeOffre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, intitule, datePublication, dureDiffusion, nombrePostes, descriptionPoste, descriptionProfile, localisation, codeOffre);
    }

    @ManyToOne
    @JoinColumn(name = "IdMetier", referencedColumnName = "Id", nullable = false)
    public MetierEntity getMetierByIdMetier() {
        return metierByIdMetier;
    }

    public void setMetierByIdMetier(MetierEntity metierByIdMetier) {
        this.metierByIdMetier = metierByIdMetier;
    }

    @ManyToOne
    @JoinColumn(name = "IdEmploye", referencedColumnName = "Id", nullable = false)
    public EmployeEntity getEmployeByIdEmploye() {
        return employeByIdEmploye;
    }

    public void setEmployeByIdEmploye(EmployeEntity employeByIdEmploye) {
        this.employeByIdEmploye = employeByIdEmploye;
    }

    @OneToMany(mappedBy = "offreByIdOffre")
    public Collection<ContratEntity> getContratsById() {
        return contratsById;
    }

    public void setContratsById(Collection<ContratEntity> contratsById) {
        this.contratsById = contratsById;
    }

    @ManyToOne
    @JoinColumn(name = "IdStudio", referencedColumnName = "Id", nullable = false)
    public StudioEntity getStudioByIdStudio() {
        return studioByIdStudio;
    }

    public void setStudioByIdStudio(StudioEntity studioByIdStudio) {
        this.studioByIdStudio = studioByIdStudio;
    }

    @OneToMany(mappedBy = "offreByIdOffre")
    public Collection<OffresInternauteEntity> getOffresInternautesById() {
        return offresInternautesById;
    }

    public void setOffresInternautesById(Collection<OffresInternauteEntity> offresInternautesById) {
        this.offresInternautesById = offresInternautesById;
    }
}
