/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "activo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a")
    , @NamedQuery(name = "Activo.findByActivoid", query = "SELECT a FROM Activo a WHERE a.activoid = :activoid")
    , @NamedQuery(name = "Activo.findByActivonombre", query = "SELECT a FROM Activo a WHERE a.activonombre = :activonombre")
    , @NamedQuery(name = "Activo.findByActivotipo", query = "SELECT a FROM Activo a WHERE a.activotipo = :activotipo")
    , @NamedQuery(name = "Activo.findByActivoserial", query = "SELECT a FROM Activo a WHERE a.activoserial = :activoserial")
    , @NamedQuery(name = "Activo.findByActivonumerointerno", query = "SELECT a FROM Activo a WHERE a.activonumerointerno = :activonumerointerno")
    , @NamedQuery(name = "Activo.findByActivopeso", query = "SELECT a FROM Activo a WHERE a.activopeso = :activopeso")
    , @NamedQuery(name = "Activo.findByActivoalto", query = "SELECT a FROM Activo a WHERE a.activoalto = :activoalto")
    , @NamedQuery(name = "Activo.findByActivoancho", query = "SELECT a FROM Activo a WHERE a.activoancho = :activoancho")
    , @NamedQuery(name = "Activo.findByActivolargo", query = "SELECT a FROM Activo a WHERE a.activolargo = :activolargo")
    , @NamedQuery(name = "Activo.findByActivovalorcompra", query = "SELECT a FROM Activo a WHERE a.activovalorcompra = :activovalorcompra")
    , @NamedQuery(name = "Activo.findByActivofechacompra", query = "SELECT a FROM Activo a WHERE a.activofechacompra = :activofechacompra")
    , @NamedQuery(name = "Activo.findByActivofechabaja", query = "SELECT a FROM Activo a WHERE a.activofechabaja = :activofechabaja")
    , @NamedQuery(name = "Activo.findByActivoestado", query = "SELECT a FROM Activo a WHERE a.activoestado = :activoestado")})
public class Activo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activoid")
    private Long activoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activonombre")
    private String activonombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "activodescripcion")
    private String activodescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "activotipo")
    private String activotipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activoserial")
    private String activoserial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activonumerointerno")
    private long activonumerointerno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activopeso")
    private double activopeso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activoalto")
    private double activoalto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activoancho")
    private double activoancho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activolargo")
    private double activolargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activovalorcompra")
    private double activovalorcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activofechacompra")
    @Temporal(TemporalType.DATE)
    private Date activofechacompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activofechabaja")
    @Temporal(TemporalType.DATE)
    private Date activofechabaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "activoestado")
    private String activoestado;
    @JoinColumn(name = "colorid", referencedColumnName = "colorid")
    @ManyToOne(optional = false)
    private Color colorid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activo")
    private Collection<Activoasignado> activoasignadoCollection;
    
    private Activoasignado activoasignado;

    public Activo() {
    }

    public Activo(Long activoid) {
        this.activoid = activoid;
    }

    public Activo(Long activoid, String activonombre, String activodescripcion, String activotipo, String activoserial, long activonumerointerno, double activopeso, double activoalto, double activoancho, double activolargo, double activovalorcompra, Date activofechacompra, Date activofechabaja, String activoestado, Color colorid, Activoasignado activoasignado) {
        this.activoid = activoid;
        this.activonombre = activonombre;
        this.activodescripcion = activodescripcion;
        this.activotipo = activotipo;
        this.activoserial = activoserial;
        this.activonumerointerno = activonumerointerno;
        this.activopeso = activopeso;
        this.activoalto = activoalto;
        this.activoancho = activoancho;
        this.activolargo = activolargo;
        this.activovalorcompra = activovalorcompra;
        this.activofechacompra = activofechacompra;
        this.activofechabaja = activofechabaja;
        this.activoestado = activoestado;
        this.colorid = colorid;
        this.activoasignado = activoasignado;
    }

    public Long getActivoid() {
        return activoid;
    }

    public void setActivoid(Long activoid) {
        this.activoid = activoid;
    }

    public String getActivonombre() {
        return activonombre;
    }

    public void setActivonombre(String activonombre) {
        this.activonombre = activonombre;
    }

    public String getActivodescripcion() {
        return activodescripcion;
    }

    public void setActivodescripcion(String activodescripcion) {
        this.activodescripcion = activodescripcion;
    }

    public String getActivotipo() {
        return activotipo;
    }

    public void setActivotipo(String activotipo) {
        this.activotipo = activotipo;
    }

    public String getActivoserial() {
        return activoserial;
    }

    public void setActivoserial(String activoserial) {
        this.activoserial = activoserial;
    }

    public long getActivonumerointerno() {
        return activonumerointerno;
    }

    public void setActivonumerointerno(long activonumerointerno) {
        this.activonumerointerno = activonumerointerno;
    }

    public double getActivopeso() {
        return activopeso;
    }

    public void setActivopeso(double activopeso) {
        this.activopeso = activopeso;
    }

    public double getActivoalto() {
        return activoalto;
    }

    public void setActivoalto(double activoalto) {
        this.activoalto = activoalto;
    }

    public double getActivoancho() {
        return activoancho;
    }

    public void setActivoancho(double activoancho) {
        this.activoancho = activoancho;
    }

    public double getActivolargo() {
        return activolargo;
    }

    public void setActivolargo(double activolargo) {
        this.activolargo = activolargo;
    }

    public double getActivovalorcompra() {
        return activovalorcompra;
    }

    public void setActivovalorcompra(double activovalorcompra) {
        this.activovalorcompra = activovalorcompra;
    }

    public Date getActivofechacompra() {
        return activofechacompra;
    }

    public void setActivofechacompra(Date activofechacompra) {
        this.activofechacompra = activofechacompra;
    }

    public Date getActivofechabaja() {
        return activofechabaja;
    }

    public void setActivofechabaja(Date activofechabaja) {
        this.activofechabaja = activofechabaja;
    }

    public String getActivoestado() {
        return activoestado;
    }

    public void setActivoestado(String activoestado) {
        this.activoestado = activoestado;
    }

    public Color getColorid() {
        return colorid;
    }

    public void setColorid(Color colorid) {
        this.colorid = colorid;
    }

    public Activoasignado getActivoasignado() {
        return activoasignado;
    }

    public void setActivoasignado(Activoasignado activoasignado) {
        this.activoasignado = activoasignado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activoid != null ? activoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.activoid == null && other.activoid != null) || (this.activoid != null && !this.activoid.equals(other.activoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Activo[ activoid=" + activoid + " ]";
    }
    
}
