/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thien
 */
@Entity
@Table(name = "ordertable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordertable.findAll", query = "SELECT o FROM Ordertable o"),
    @NamedQuery(name = "Ordertable.findByOrderID", query = "SELECT o FROM Ordertable o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "Ordertable.findByOrderDate", query = "SELECT o FROM Ordertable o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Ordertable.findByOrderTotal", query = "SELECT o FROM Ordertable o WHERE o.orderTotal = :orderTotal"),
    @NamedQuery(name = "Ordertable.findByDeliveryDate", query = "SELECT o FROM Ordertable o WHERE o.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Ordertable.findByStatus", query = "SELECT o FROM Ordertable o WHERE o.status = :status")})
public class Ordertable implements Serializable {
    @Column(name = "totalPrice")
    private Float totalPrice;
    @Size(max = 45)
    @Column(name = "receiveName")
    private String receiveName;
    @Size(max = 45)
    @Column(name = "receiveAddress")
    private String receiveAddress;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderID")
    private Integer orderID;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OrderTotal")
    private Float orderTotal;
    @Column(name = "DeliveryDate")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordertableOrderNumber")
    private List<Shiptable> shiptableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordertableOrderNumber")
    private List<Buyer> buyerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordertableOrderNumber")
    private List<Orderline> orderlineList;
    @JoinColumn(name = "CusID", referencedColumnName = "CusID")
    @ManyToOne
    private Customer cusID;

    public Ordertable() {
    }

    public Ordertable(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Shiptable> getShiptableList() {
        return shiptableList;
    }

    public void setShiptableList(List<Shiptable> shiptableList) {
        this.shiptableList = shiptableList;
    }

    @XmlTransient
    public List<Buyer> getBuyerList() {
        return buyerList;
    }

    public void setBuyerList(List<Buyer> buyerList) {
        this.buyerList = buyerList;
    }

    @XmlTransient
    public List<Orderline> getOrderlineList() {
        return orderlineList;
    }

    public void setOrderlineList(List<Orderline> orderlineList) {
        this.orderlineList = orderlineList;
    }

    public Customer getCusID() {
        return cusID;
    }

    public void setCusID(Customer cusID) {
        this.cusID = cusID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordertable)) {
            return false;
        }
        Ordertable other = (Ordertable) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Ordertable[ orderID=" + orderID + " ]";
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
