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
@Table(name = "accessimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessimage.findAll", query = "SELECT a FROM Accessimage a"),
    @NamedQuery(name = "Accessimage.findByAccessImageID", query = "SELECT a FROM Accessimage a WHERE a.accessImageID = :accessImageID"),
    @NamedQuery(name = "Accessimage.findByAccesssoryPicUrl", query = "SELECT a FROM Accessimage a WHERE a.accesssoryPicUrl = :accesssoryPicUrl")})
public class Accessimage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccessImageID")
    private Integer accessImageID;
    @Size(max = 45)
    @Column(name = "AccesssoryPicUrl")
    private String accesssoryPicUrl;
    @JoinColumn(name = "Accessory_AccessoryID", referencedColumnName = "AccessoryID")
    @ManyToOne(optional = false)
    private Accessory accessoryAccessoryID;

    public Accessimage() {
    }

    public Accessimage(Integer accessImageID) {
        this.accessImageID = accessImageID;
    }

    public Integer getAccessImageID() {
        return accessImageID;
    }

    public void setAccessImageID(Integer accessImageID) {
        this.accessImageID = accessImageID;
    }

    public String getAccesssoryPicUrl() {
        return accesssoryPicUrl;
    }

    public void setAccesssoryPicUrl(String accesssoryPicUrl) {
        this.accesssoryPicUrl = accesssoryPicUrl;
    }

    public Accessory getAccessoryAccessoryID() {
        return accessoryAccessoryID;
    }

    public void setAccessoryAccessoryID(Accessory accessoryAccessoryID) {
        this.accessoryAccessoryID = accessoryAccessoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessImageID != null ? accessImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessimage)) {
            return false;
        }
        Accessimage other = (Accessimage) object;
        if ((this.accessImageID == null && other.accessImageID != null) || (this.accessImageID != null && !this.accessImageID.equals(other.accessImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Accessimage[ accessImageID=" + accessImageID + " ]";
    }
    
}
