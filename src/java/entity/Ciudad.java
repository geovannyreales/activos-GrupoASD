/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCiudadid", query = "SELECT c FROM Ciudad c WHERE c.ciudadid = :ciudadid")
    , @NamedQuery(name = "Ciudad.findByCiudadnombre", query = "SELECT c FROM Ciudad c WHERE c.ciudadnombre = :ciudadnombre")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciudadid")
    private Integer ciudadid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudadnombre")
    private String ciudadnombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadid")
    private Collection<Area> areaCollection;

    public Ciudad() {
    }

    public Ciudad(Integer ciudadid) {
        this.ciudadid = ciudadid;
    }

    public Ciudad(Integer ciudadid, String ciudadnombre) {
        this.ciudadid = ciudadid;
        this.ciudadnombre = ciudadnombre;
    }

    public Integer getCiudadid() {
        return ciudadid;
    }

    public void setCiudadid(Integer ciudadid) {
        this.ciudadid = ciudadid;
    }

    public String getCiudadnombre() {
        return ciudadnombre;
    }

    public void setCiudadnombre(String ciudadnombre) {
        this.ciudadnombre = ciudadnombre;
    }

    @XmlTransient
    public Collection<Area> getAreaCollection() {
        return areaCollection;
    }

    public void setAreaCollection(Collection<Area> areaCollection) {
        this.areaCollection = areaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadid != null ? ciudadid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadid == null && other.ciudadid != null) || (this.ciudadid != null && !this.ciudadid.equals(other.ciudadid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ciudad[ ciudadid=" + ciudadid + " ]";
    }
    
}
