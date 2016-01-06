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
@Table(name = "orderline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderline.findAll", query = "SELECT o FROM Orderline o"),
    @NamedQuery(name = "Orderline.findByOrderLineID", query = "SELECT o FROM Orderline o WHERE o.orderLineID = :orderLineID"),
    @NamedQuery(name = "Orderline.findByQuantity", query = "SELECT o FROM Orderline o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderline.findByUnitprice", query = "SELECT o FROM Orderline o WHERE o.unitprice = :unitprice"),
    @NamedQuery(name = "Orderline.findByPricePromotion", query = "SELECT o FROM Orderline o WHERE o.pricePromotion = :pricePromotion"),
    @NamedQuery(name = "Orderline.findByTotal", query = "SELECT o FROM Orderline o WHERE o.total = :total")})
public class Orderline implements Serializable {
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "Total")
    private Float total;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderLineID")
    private Integer orderLineID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unitprice")
    private Float unitprice;
    @Column(name = "PricePromotion")
    private Float pricePromotion;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne
    private Product productID;
    @JoinColumn(name = "ordertable_OrderNumber", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Ordertable ordertableOrderNumber;

    public Orderline() {
    }

    public Orderline(Integer orderLineID) {
        this.orderLineID = orderLineID;
    }

    public Integer getOrderLineID() {
        return orderLineID;
    }

    public void setOrderLineID(Integer orderLineID) {
        this.orderLineID = orderLineID;
    }


    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }

    public Float getPricePromotion() {
        return pricePromotion;
    }

    public void setPricePromotion(Float pricePromotion) {
        this.pricePromotion = pricePromotion;
    }


    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
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
        hash += (orderLineID != null ? orderLineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderline)) {
            return false;
        }
        Orderline other = (Orderline) object;
        if ((this.orderLineID == null && other.orderLineID != null) || (this.orderLineID != null && !this.orderLineID.equals(other.orderLineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Orderline[ orderLineID=" + orderLineID + " ]";
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
