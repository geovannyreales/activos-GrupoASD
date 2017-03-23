/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "activoasignado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activoasignado.findAll", query = "SELECT a FROM Activoasignado a")
    , @NamedQuery(name = "Activoasignado.findByActivoid", query = "SELECT a FROM Activoasignado a WHERE a.activoasignadoPK.activoid = :activoid")
    , @NamedQuery(name = "Activoasignado.findByContext", query = "SELECT a FROM Activoasignado a WHERE a.activoasignadoPK.context = :context")
    , @NamedQuery(name = "Activoasignado.findByInstanceid", query = "SELECT a FROM Activoasignado a WHERE a.activoasignadoPK.instanceid = :instanceid")
    , @NamedQuery(name = "Activoasignado.findByActivoasignadofecha", query = "SELECT a FROM Activoasignado a WHERE a.activoasignadofecha = :activoasignadofecha")})
public class Activoasignado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivoasignadoPK activoasignadoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activoasignadofecha")
    @Temporal(TemporalType.DATE)
    private Date activoasignadofecha;
    @JoinColumn(name = "activoid", referencedColumnName = "activoid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Activo activo;

    private Persona persona;
    private Area area;

    public Activoasignado() {
    }

    public Activoasignado(ActivoasignadoPK activoasignadoPK) {
        this.activoasignadoPK = activoasignadoPK;
    }

    public Activoasignado(ActivoasignadoPK activoasignadoPK, Date activoasignadofecha) {
        this.activoasignadoPK = activoasignadoPK;
        this.activoasignadofecha = activoasignadofecha;
    }

    public Activoasignado(ActivoasignadoPK activoasignadoPK, Date activoasignadofecha, Persona persona) {
        this.activoasignadoPK = activoasignadoPK;
        this.activoasignadofecha = activoasignadofecha;
        this.persona = persona;
    }

    public Activoasignado(ActivoasignadoPK activoasignadoPK, Date activoasignadofecha, Area area) {
        this.activoasignadoPK = activoasignadoPK;
        this.activoasignadofecha = activoasignadofecha;
        this.area = area;
    }

    public Activoasignado(long activoid, String context, int instanceid) {
        this.activoasignadoPK = new ActivoasignadoPK(activoid, context, instanceid);
    }

    public ActivoasignadoPK getActivoasignadoPK() {
        return activoasignadoPK;
    }

    public void setActivoasignadoPK(ActivoasignadoPK activoasignadoPK) {
        this.activoasignadoPK = activoasignadoPK;
    }

    public Date getActivoasignadofecha() {
        return activoasignadofecha;
    }

    public void setActivoasignadofecha(Date activoasignadofecha) {
        this.activoasignadofecha = activoasignadofecha;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activoasignadoPK != null ? activoasignadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activoasignado)) {
            return false;
        }
        Activoasignado other = (Activoasignado) object;
        if ((this.activoasignadoPK == null && other.activoasignadoPK != null) || (this.activoasignadoPK != null && !this.activoasignadoPK.equals(other.activoasignadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Activoasignado[ activoasignadoPK=" + activoasignadoPK + " ]";
    }

}
