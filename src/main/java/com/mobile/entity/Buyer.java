/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thien
 */
@Entity
@Table(name = "buyer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buyer.findAll", query = "SELECT b FROM Buyer b"),
    @NamedQuery(name = "Buyer.findByBuyerID", query = "SELECT b FROM Buyer b WHERE b.buyerID = :buyerID"),
    @NamedQuery(name = "Buyer.findByName", query = "SELECT b FROM Buyer b WHERE b.name = :name"),
    @NamedQuery(name = "Buyer.findByTel", query = "SELECT b FROM Buyer b WHERE b.tel = :tel"),
    @NamedQuery(name = "Buyer.findByColor", query = "SELECT b FROM Buyer b WHERE b.color = :color"),
    @NamedQuery(name = "Buyer.findByCity", query = "SELECT b FROM Buyer b WHERE b.city = :city"),
    @NamedQuery(name = "Buyer.findByDistrict", query = "SELECT b FROM Buyer b WHERE b.district = :district"),
    @NamedQuery(name = "Buyer.findByAddress", query = "SELECT b FROM Buyer b WHERE b.address = :address")})
public class Buyer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyerID")
    private Integer buyerID;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 45)
    @Column(name = "Tel")
    private String tel;
    @Size(max = 45)
    @Column(name = "Color")
    private String color;
    @Size(max = 45)
    @Column(name = "City")
    private String city;
    @Size(max = 45)
    @Column(name = "district")
    private String district;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "ordertable_OrderNumber", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Ordertable ordertableOrderNumber;

    public Buyer() {
    }

    public Buyer(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public Integer getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        hash += (buyerID != null ? buyerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buyer)) {
            return false;
        }
        Buyer other = (Buyer) object;
        if ((this.buyerID == null && other.buyerID != null) || (this.buyerID != null && !this.buyerID.equals(other.buyerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Buyer[ buyerID=" + buyerID + " ]";
    }
    
}
