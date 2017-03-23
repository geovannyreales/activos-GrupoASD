/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findById", query = "SELECT a FROM Area a WHERE a.id = :id")
    , @NamedQuery(name = "Area.findByAreanombre", query = "SELECT a FROM Area a WHERE a.areanombre = :areanombre")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "areanombre")
    private String areanombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "areadescripcion")
    private String areadescripcion;
    @JoinColumn(name = "ciudadid", referencedColumnName = "ciudadid")
    @ManyToOne(optional = false)
    private Ciudad ciudadid;

    public Area() {
    }

    public Area(Integer id) {
        this.id = id;
    }

    public Area(Integer id, String areanombre, String areadescripcion, Ciudad ciudad) {
        this.id = id;
        this.areanombre = areanombre;
        this.areadescripcion = areadescripcion;
        this.ciudadid = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreanombre() {
        return areanombre;
    }

    public void setAreanombre(String areanombre) {
        this.areanombre = areanombre;
    }

    public String getAreadescripcion() {
        return areadescripcion;
    }

    public void setAreadescripcion(String areadescripcion) {
        this.areadescripcion = areadescripcion;
    }

    public Ciudad getCiudadid() {
        return ciudadid;
    }

    public void setCiudadid(Ciudad ciudadid) {
        this.ciudadid = ciudadid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Area[ id=" + id + " ]";
    }
    
}
