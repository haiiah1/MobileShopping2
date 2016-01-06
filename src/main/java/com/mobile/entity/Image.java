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
 * @author congt
 */
@Entity
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findByImageID", query = "SELECT i FROM Image i WHERE i.imageID = :imageID"),
    @NamedQuery(name = "Image.findByProductPictureName", query = "SELECT i FROM Image i WHERE i.productPictureName = :productPictureName")})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImageID")
    private Integer imageID;
    @Size(max = 50)
    @Column(name = "ProductPictureName")
    private String productPictureName;
    @JoinColumn(name = "product_ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Product productProductID;

    public Image() {
    }

    public Image(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getProductPictureName() {
        return productPictureName;
    }

    public void setProductPictureName(String productPictureName) {
        this.productPictureName = productPictureName;
    }

    public Product getProductProductID() {
        return productProductID;
    }

    public void setProductProductID(Product productProductID) {
        this.productProductID = productProductID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Image[ imageID=" + imageID + " ]";
    }
    
}
