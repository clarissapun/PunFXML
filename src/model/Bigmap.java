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
@Table(name = "BIGMAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bigmap.findAll", query = "SELECT b FROM Bigmap b"),
    @NamedQuery(name = "Bigmap.findByMapid", query = "SELECT b FROM Bigmap b WHERE b.mapid = :mapid"),
    @NamedQuery(name = "Bigmap.findByNumroutes", query = "SELECT b FROM Bigmap b WHERE b.numroutes = :numroutes")})
public class Bigmap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MAPID")
    private Integer mapid;
    @Column(name = "NUMROUTES")
    private Integer numroutes;

    public Bigmap() {
    }

    public Bigmap(Integer mapid) {
        this.mapid = mapid;
    }

    public Integer getMapid() {
        return mapid;
    }

    public void setMapid(Integer mapid) {
        this.mapid = mapid;
    }

    public Integer getNumroutes() {
        return numroutes;
    }

    public void setNumroutes(Integer numroutes) {
        this.numroutes = numroutes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mapid != null ? mapid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bigmap)) {
            return false;
        }
        Bigmap other = (Bigmap) object;
        if ((this.mapid == null && other.mapid != null) || (this.mapid != null && !this.mapid.equals(other.mapid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bigmap[ mapid=" + mapid + " ]";
    }
    
}
