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
@Table(name = "DELIVERYSERVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveryservice.findAll", query = "SELECT d FROM Deliveryservice d"),
    @NamedQuery(name = "Deliveryservice.findByCompany", query = "SELECT d FROM Deliveryservice d WHERE d.company = :company"),
    @NamedQuery(name = "Deliveryservice.findByCompanyid", query = "SELECT d FROM Deliveryservice d WHERE d.companyid = :companyid")})
public class Deliveryservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "COMPANY")
    private String company;
    @Id
    @Basic(optional = false)
    @Column(name = "COMPANYID")
    private Integer companyid;

    public Deliveryservice() {
    }

    public Deliveryservice(Integer companyid) {
        this.companyid = companyid;
    }

    public Deliveryservice(Integer companyid, String company) {
        this.companyid = companyid;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyid != null ? companyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliveryservice)) {
            return false;
        }
        Deliveryservice other = (Deliveryservice) object;
        if ((this.companyid == null && other.companyid != null) || (this.companyid != null && !this.companyid.equals(other.companyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Deliveryservice[ companyid=" + companyid + " ]";
    }
    
}
