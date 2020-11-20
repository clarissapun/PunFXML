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
@Table(name = "PACKAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findById", query = "SELECT p FROM Packages p WHERE p.id = :id"),
    @NamedQuery(name = "Packages.findByCompany", query = "SELECT p FROM Packages p WHERE p.company = :company"),
    @NamedQuery(name = "Packages.findByToaddress", query = "SELECT p FROM Packages p WHERE p.toaddress = :toaddress"),
    @NamedQuery(name = "Packages.findByFromaddress", query = "SELECT p FROM Packages p WHERE p.fromaddress = :fromaddress"),
    @NamedQuery(name = "Packages.findByCompanyAdvanced", query = "SELECT p FROM Packages p WHERE LOWER(p.company) LIKE CONCAT(LOWER(:company), '%')")
                                                            //"SELECT p FROM Packages p WHERE LOWER(p.company) LIKE CONCAT(LOWER(:company), '%')")
                                                            // "SELECT p FROM Packages p WHERE ((SELECT CAST(p.id as VARCHAR) FROM Packages p) LIKE CONCAT(:id, '%'))")
})

public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "COMPANY")
    private String company;
    @Basic(optional = false)
    @Column(name = "TOADDRESS")
    private String toaddress;
    @Basic(optional = false)
    @Column(name = "FROMADDRESS")
    private String fromaddress;

    public Packages() {
    }

    public Packages(Integer id) {
        this.id = id;
    }

    public Packages(Integer id, String company, String toaddress, String fromaddress) {
        this.id = id;
        this.company = company;
        this.toaddress = toaddress;
        this.fromaddress = fromaddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getToaddress() {
        return toaddress;
    }

    public void setToaddress(String toaddress) {
        this.toaddress = toaddress;
    }

    public String getFromaddress() {
        return fromaddress;
    }

    public void setFromaddress(String fromaddress) {
        this.fromaddress = fromaddress;
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
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Packages[ id=" + id + " ]";
    }
    
}
