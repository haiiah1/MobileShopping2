/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thien
 */
@Entity
@Table(name = "shiptable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shiptable.findAll", query = "SELECT s FROM Shiptable s"),
    @NamedQuery(name = "Shiptable.findByShiptableID", query = "SELECT s FROM Shiptable s WHERE s.shiptableID = :shiptableID"),
    @NamedQuery(name = "Shiptable.findByName", query = "SELECT s FROM Shiptable s WHERE s.name = :name"),
    @NamedQuery(name = "Shiptable.findByShipdate", query = "SELECT s FROM Shiptable s WHERE s.shipdate = :shipdate"),
    @NamedQuery(name = "Shiptable.findByTel", query = "SELECT s FROM Shiptable s WHERE s.tel = :tel")})
public class Shiptable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shiptableID")
    private Integer shiptableID;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Column(name = "shipdate")
    @Temporal(TemporalType.DATE)
    private Date shipdate;
    @Size(max = 45)
    @Column(name = "Tel")
    private String tel;
    @JoinColumn(name = "ordertable_OrderNumber", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Ordertable ordertableOrderNumber;

    public Shiptable() {
    }

    public Shiptable(Integer shiptableID) {
        this.shiptableID = shiptableID;
    }

    public Integer getShiptableID() {
        return shiptableID;
    }

    public void setShiptableID(Integer shiptableID) {
        this.shiptableID = shiptableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Ordertable getOrdertableOrderNumber() {
        return ordertableOrderNumber;
    }

    public void setOrdertableOrderNumber(Ordertable ordertableOrderNumber) {
        this.ordertableOrderNumber = ordertableOrderNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiptableID != null ? shiptableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shiptable)) {
            return false;
        }
        Shiptable other = (Shiptable) object;
        if ((this.shiptableID == null && other.shiptableID != null) || (this.shiptableID != null && !this.shiptableID.equals(other.shiptableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Shiptable[ shiptableID=" + shiptableID + " ]";
    }
    
}
