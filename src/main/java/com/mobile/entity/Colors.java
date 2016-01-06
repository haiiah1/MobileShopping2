/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author congt
 */
@Entity
@Table(name = "colors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colors.findAll", query = "SELECT c FROM Colors c"),
    @NamedQuery(name = "Colors.findByColorID", query = "SELECT c FROM Colors c WHERE c.colorID = :colorID"),
    @NamedQuery(name = "Colors.findByName", query = "SELECT c FROM Colors c WHERE c.name = :name")})
public class Colors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "colorID")
    private Integer colorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "productcolor", joinColumns = {
        @JoinColumn(name = "colors_colorID", referencedColumnName = "colorID")}, inverseJoinColumns = {
        @JoinColumn(name = "product_ProductID", referencedColumnName = "ProductID")})
    @ManyToMany
    private List<Product> productList;

    public Colors() {
    }

    public Colors(Integer colorID) {
        this.colorID = colorID;
    }

    public Colors(Integer colorID, String name) {
        this.colorID = colorID;
        this.name = name;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colorID != null ? colorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colors)) {
            return false;
        }
        Colors other = (Colors) object;
        if ((this.colorID == null && other.colorID != null) || (this.colorID != null && !this.colorID.equals(other.colorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Colors[ colorID=" + colorID + " ]";
    }
    
}
