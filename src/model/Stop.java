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
@Table(name = "STOP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stop.findAll", query = "SELECT s FROM Stop s"),
    @NamedQuery(name = "Stop.findByLocation", query = "SELECT s FROM Stop s WHERE s.location = :location"),
    @NamedQuery(name = "Stop.findByIsthere", query = "SELECT s FROM Stop s WHERE s.isthere = :isthere"),
    @NamedQuery(name = "Stop.findById", query = "SELECT s FROM Stop s WHERE s.id = :id")})
public class Stop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "LOCATION")
    private String location;
    @Basic(optional = false)
    @Column(name = "ISTHERE")
    private Boolean isthere;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Stop() {
    }

    public Stop(Integer id) {
        this.id = id;
    }

    public Stop(Integer id, String location, Boolean isthere) {
        this.id = id;
        this.location = location;
        this.isthere = isthere;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsthere() {
        return isthere;
    }

    public void setIsthere(Boolean isthere) {
        this.isthere = isthere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Stop)) {
            return false;
        }
        Stop other = (Stop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stop[ id=" + id + " ]";
    }
    
}
