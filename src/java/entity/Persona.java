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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPersonaid", query = "SELECT p FROM Persona p WHERE p.personaid = :personaid")
    , @NamedQuery(name = "Persona.findByPersonanombre", query = "SELECT p FROM Persona p WHERE p.personanombre = :personanombre")
    , @NamedQuery(name = "Persona.findByPersonaapellido", query = "SELECT p FROM Persona p WHERE p.personaapellido = :personaapellido")
    , @NamedQuery(name = "Persona.findByPersonanumerodocumento", query = "SELECT p FROM Persona p WHERE p.personanumerodocumento = :personanumerodocumento")
    , @NamedQuery(name = "Persona.findByPersonaemail", query = "SELECT p FROM Persona p WHERE p.personaemail = :personaemail")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personaid")
    private Long personaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "personanombre")
    private String personanombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "personaapellido")
    private String personaapellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "personanumerodocumento")
    private String personanumerodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "personaemail")
    private String personaemail;

    public Persona() {
    }

    public Persona(Long personaid) {
        this.personaid = personaid;
    }

    public Persona(Long personaid, String personanombre, String personaapellido, String personanumerodocumento, String personaemail) {
        this.personaid = personaid;
        this.personanombre = personanombre;
        this.personaapellido = personaapellido;
        this.personanumerodocumento = personanumerodocumento;
        this.personaemail = personaemail;
    }

    public Long getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Long personaid) {
        this.personaid = personaid;
    }

    public String getPersonanombre() {
        return personanombre;
    }

    public void setPersonanombre(String personanombre) {
        this.personanombre = personanombre;
    }

    public String getPersonaapellido() {
        return personaapellido;
    }

    public void setPersonaapellido(String personaapellido) {
        this.personaapellido = personaapellido;
    }

    public String getPersonanumerodocumento() {
        return personanumerodocumento;
    }

    public void setPersonanumerodocumento(String personanumerodocumento) {
        this.personanumerodocumento = personanumerodocumento;
    }

    public String getPersonaemail() {
        return personaemail;
    }

    public void setPersonaemail(String personaemail) {
        this.personaemail = personaemail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaid != null ? personaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaid == null && other.personaid != null) || (this.personaid != null && !this.personaid.equals(other.personaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Persona[ personaid=" + personaid + " ]";
    }
    
}
