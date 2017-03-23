/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adm
 */
@Embeddable
public class ActivoasignadoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "activoid")
    private long activoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "context")
    private String context;
    @Basic(optional = false)
    @NotNull
    @Column(name = "instanceid")
    private int instanceid;

    public ActivoasignadoPK() {
    }

    public ActivoasignadoPK(long activoid, String context, int instanceid) {
        this.activoid = activoid;
        this.context = context;
        this.instanceid = instanceid;
    }

    public long getActivoid() {
        return activoid;
    }

    public void setActivoid(long activoid) {
        this.activoid = activoid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(int instanceid) {
        this.instanceid = instanceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) activoid;
        hash += (context != null ? context.hashCode() : 0);
        hash += (int) instanceid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoasignadoPK)) {
            return false;
        }
        ActivoasignadoPK other = (ActivoasignadoPK) object;
        if (this.activoid != other.activoid) {
            return false;
        }
        if ((this.context == null && other.context != null) || (this.context != null && !this.context.equals(other.context))) {
            return false;
        }
        if (this.instanceid != other.instanceid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ActivoasignadoPK[ activoid=" + activoid + ", context=" + context + ", instanceid=" + instanceid + " ]";
    }
    
}
