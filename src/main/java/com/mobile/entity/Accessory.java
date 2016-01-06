/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author congt
 */
@Entity
@Table(name = "accessory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessory.findAll", query = "SELECT a FROM Accessory a"),
    @NamedQuery(name = "Accessory.findByAccessoryID", query = "SELECT a FROM Accessory a WHERE a.accessoryID = :accessoryID"),
    @NamedQuery(name = "Accessory.findByName", query = "SELECT a FROM Accessory a WHERE a.name = :name"),
    @NamedQuery(name = "Accessory.findByTitle", query = "SELECT a FROM Accessory a WHERE a.title = :title"),
    @NamedQuery(name = "Accessory.findByColor", query = "SELECT a FROM Accessory a WHERE a.color = :color"),
    @NamedQuery(name = "Accessory.findByContent", query = "SELECT a FROM Accessory a WHERE a.content = :content")})
public class Accessory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccessoryID")
    private Integer accessoryID;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 45)
    @Column(name = "Title")
    private String title;
    @Size(max = 45)
    @Column(name = "Color")
    private String color;
    @Size(max = 45)
    @Column(name = "Content")
    private String content;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessoryAccessoryID")
    private List<Accessimage> accessimageList;
    @JoinColumn(name = "AccessCategory_AccessCategoryID", referencedColumnName = "AccessCategoryID")
    @ManyToOne(optional = false)
    private Accesscategory accessCategoryAccessCategoryID;

    public Accessory() {
    }

    public Accessory(Integer accessoryID) {
        this.accessoryID = accessoryID;
    }

    public Integer getAccessoryID() {
        return accessoryID;
    }

    public void setAccessoryID(Integer accessoryID) {
        this.accessoryID = accessoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public List<Accessimage> getAccessimageList() {
        return accessimageList;
    }

    public void setAccessimageList(List<Accessimage> accessimageList) {
        this.accessimageList = accessimageList;
    }

    public Accesscategory getAccessCategoryAccessCategoryID() {
        return accessCategoryAccessCategoryID;
    }

    public void setAccessCategoryAccessCategoryID(Accesscategory accessCategoryAccessCategoryID) {
        this.accessCategoryAccessCategoryID = accessCategoryAccessCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessoryID != null ? accessoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessory)) {
            return false;
        }
        Accessory other = (Accessory) object;
        if ((this.accessoryID == null && other.accessoryID != null) || (this.accessoryID != null && !this.accessoryID.equals(other.accessoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Accessory[ accessoryID=" + accessoryID + " ]";
    }
    
}
