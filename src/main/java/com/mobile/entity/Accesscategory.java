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
@Table(name = "accesscategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accesscategory.findAll", query = "SELECT a FROM Accesscategory a"),
    @NamedQuery(name = "Accesscategory.findByAccessCategoryID", query = "SELECT a FROM Accesscategory a WHERE a.accessCategoryID = :accessCategoryID"),
    @NamedQuery(name = "Accesscategory.findByName", query = "SELECT a FROM Accesscategory a WHERE a.name = :name")})
public class Accesscategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccessCategoryID")
    private Integer accessCategoryID;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessCategoryAccessCategoryID")
    private List<Accessory> accessoryList;

    public Accesscategory() {
    }

    public Accesscategory(Integer accessCategoryID) {
        this.accessCategoryID = accessCategoryID;
    }

    public Integer getAccessCategoryID() {
        return accessCategoryID;
    }

    public void setAccessCategoryID(Integer accessCategoryID) {
        this.accessCategoryID = accessCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Accessory> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(List<Accessory> accessoryList) {
        this.accessoryList = accessoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessCategoryID != null ? accessCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesscategory)) {
            return false;
        }
        Accesscategory other = (Accesscategory) object;
        if ((this.accessCategoryID == null && other.accessCategoryID != null) || (this.accessCategoryID != null && !this.accessCategoryID.equals(other.accessCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Accesscategory[ accessCategoryID=" + accessCategoryID + " ]";
    }
    
}
