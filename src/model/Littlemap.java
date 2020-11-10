/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clarissapun
 */
@Entity
@Table(name = "LITTLEMAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Littlemap.findAll", query = "SELECT l FROM Littlemap l"),
    @NamedQuery(name = "Littlemap.findByLmapid", query = "SELECT l FROM Littlemap l WHERE l.lmapid = :lmapid"),
    @NamedQuery(name = "Littlemap.findByNumstops", query = "SELECT l FROM Littlemap l WHERE l.numstops = :numstops")})
public class Littlemap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LMAPID")
    private Integer lmapid;
    @Column(name = "NUMSTOPS")
    private Integer numstops;

    public Littlemap() {
    }

    public Littlemap(Integer lmapid) {
        this.lmapid = lmapid;
    }

    public Integer getLmapid() {
        return lmapid;
    }

    public void setLmapid(Integer lmapid) {
        this.lmapid = lmapid;
    }

    public Integer getNumstops() {
        return numstops;
    }

    public void setNumstops(Integer numstops) {
        this.numstops = numstops;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lmapid != null ? lmapid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Littlemap)) {
            return false;
        }
        Littlemap other = (Littlemap) object;
        if ((this.lmapid == null && other.lmapid != null) || (this.lmapid != null && !this.lmapid.equals(other.lmapid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Littlemap[ lmapid=" + lmapid + " ]";
    }
    
}
