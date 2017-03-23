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
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")
    , @NamedQuery(name = "Color.findByColorid", query = "SELECT c FROM Color c WHERE c.colorid = :colorid")
    , @NamedQuery(name = "Color.findByColornombre", query = "SELECT c FROM Color c WHERE c.colornombre = :colornombre")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colorid")
    private Integer colorid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "colornombre")
    private String colornombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorid")
    private Collection<Activo> activoCollection;

    public Color() {
    }

    public Color(Integer colorid) {
        this.colorid = colorid;
    }

    public Color(Integer colorid, String colornombre) {
        this.colorid = colorid;
        this.colornombre = colornombre;
    }

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public String getColornombre() {
        return colornombre;
    }

    public void setColornombre(String colornombre) {
        this.colornombre = colornombre;
    }

    @XmlTransient
    public Collection<Activo> getActivoCollection() {
        return activoCollection;
    }

    public void setActivoCollection(Collection<Activo> activoCollection) {
        this.activoCollection = activoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colorid != null ? colorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.colorid == null && other.colorid != null) || (this.colorid != null && !this.colorid.equals(other.colorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Color[ colorid=" + colorid + " ]";
    }
    
}
