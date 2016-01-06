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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({    
    @NamedQuery(name = "Product.findCate", query = "SELECT p FROM Product p"
                + " WHERE p.categoryID = :categoryID "),
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name like :name"),
    @NamedQuery(name = "Product.findByQuantityInStock", query = "SELECT p FROM Product p WHERE p.quantityInStock = :quantityInStock"),
    @NamedQuery(name = "Product.findByUnitPrice", query = "SELECT p FROM Product p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "Product.findByPricePromotion", query = "SELECT p FROM Product p WHERE p.pricePromotion = :pricePromotion"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status"),
    @NamedQuery(name = "Product.findByEnterDate", query = "SELECT p FROM Product p WHERE p.enterDate = :enterDate"),
    @NamedQuery(name = "Product.findByUpdateDate", query = "SELECT p FROM Product p WHERE p.updateDate = :updateDate"),
    @NamedQuery(name = "Product.findByPublishDate", query = "SELECT p FROM Product p WHERE p.publishDate = :publishDate"),
    @NamedQuery(name = "Product.findByManufacturer", query = "SELECT p FROM Product p WHERE p.manufacturer = :manufacturer"),
    @NamedQuery(name = "Product.findByModel", query = "SELECT p FROM Product p WHERE p.model = :model"),
    @NamedQuery(name = "Product.findBySoldQuantity", query = "SELECT p FROM Product p WHERE p.soldQuantity = :soldQuantity"),
    @NamedQuery(name = "Product.findByMainImageURL", query = "SELECT p FROM Product p WHERE p.mainImageURL = :mainImageURL")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductID")
    private Integer productID;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Introduce")
    private String introduce;
    @Column(name = "QuantityInStock")
    private Integer quantityInStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UnitPrice")
    private Float unitPrice;
    @Column(name = "PricePromotion")
    private Float pricePromotion;
    @Size(max = 45)
    @Column(name = "Status")
    private String status;
    @Column(name = "EnterDate")
    @Temporal(TemporalType.DATE)
    private Date enterDate;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "PublishDate")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @Size(max = 45)
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Size(max = 45)
    @Column(name = "Model")
    private String model;
    @Column(name = "SoldQuantity")
    private Integer soldQuantity;
    @Size(max = 100)
    @Column(name = "MainImageURL")
    private String mainImageURL;
    @ManyToMany(mappedBy = "productList")
    private List<Colors> colorsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productProductID")
    private List<Image> imageList;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    @ManyToOne
    private Category categoryID;
    @JoinColumn(name = "detail_DetailID", referencedColumnName = "DetailID")
    @ManyToOne(optional = false)
    private Detail detailDetailID;
    @OneToMany(mappedBy = "productID")
    private List<Orderline> orderlineList;

    public Product() {
    }

    public Product(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getPricePromotion() {
        return pricePromotion;
    }

    public void setPricePromotion(Float pricePromotion) {
        this.pricePromotion = pricePromotion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getMainImageURL() {
        return mainImageURL;
    }

    public void setMainImageURL(String mainImageURL) {
        this.mainImageURL = mainImageURL;
    }

    @XmlTransient
    public List<Colors> getColorsList() {
        return colorsList;
    }

    public void setColorsList(List<Colors> colorsList) {
        this.colorsList = colorsList;
    }

    @XmlTransient
    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public Detail getDetailDetailID() {
        return detailDetailID;
    }

    public void setDetailDetailID(Detail detailDetailID) {
        this.detailDetailID = detailDetailID;
    }

    @XmlTransient
    public List<Orderline> getOrderlineList() {
        return orderlineList;
    }

    public void setOrderlineList(List<Orderline> orderlineList) {
        this.orderlineList = orderlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Product[ productID=" + productID + " ]";
    }
    
}
