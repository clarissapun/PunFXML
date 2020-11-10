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
@Table(name = "INTERNATIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "International.findAll", query = "SELECT i FROM International i"),
    @NamedQuery(name = "International.findByCountryid", query = "SELECT i FROM International i WHERE i.countryid = :countryid"),
    @NamedQuery(name = "International.findByShippingtype", query = "SELECT i FROM International i WHERE i.shippingtype = :shippingtype"),
    @NamedQuery(name = "International.findByIsinternational", query = "SELECT i FROM International i WHERE i.isinternational = :isinternational"),
    @NamedQuery(name = "International.findByOrigincountry", query = "SELECT i FROM International i WHERE i.origincountry = :origincountry"),
    @NamedQuery(name = "International.findByShipprice", query = "SELECT i FROM International i WHERE i.shipprice = :shipprice")})
public class International implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COUNTRYID")
    private Integer countryid;
    @Column(name = "SHIPPINGTYPE")
    private String shippingtype;
    @Column(name = "ISINTERNATIONAL")
    private Boolean isinternational;
    @Column(name = "ORIGINCOUNTRY")
    private String origincountry;
    @Basic(optional = false)
    @Column(name = "SHIPPRICE")
    private double shipprice;

    public International() {
    }

    public International(Integer countryid) {
        this.countryid = countryid;
    }

    public International(Integer countryid, double shipprice) {
        this.countryid = countryid;
        this.shipprice = shipprice;
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public String getShippingtype() {
        return shippingtype;
    }

    public void setShippingtype(String shippingtype) {
        this.shippingtype = shippingtype;
    }

    public Boolean getIsinternational() {
        return isinternational;
    }

    public void setIsinternational(Boolean isinternational) {
        this.isinternational = isinternational;
    }

    public String getOrigincountry() {
        return origincountry;
    }

    public void setOrigincountry(String origincountry) {
        this.origincountry = origincountry;
    }

    public double getShipprice() {
        return shipprice;
    }

    public void setShipprice(double shipprice) {
        this.shipprice = shipprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryid != null ? countryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof International)) {
            return false;
        }
        International other = (International) object;
        if ((this.countryid == null && other.countryid != null) || (this.countryid != null && !this.countryid.equals(other.countryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.International[ countryid=" + countryid + " ]";
    }
    
}
