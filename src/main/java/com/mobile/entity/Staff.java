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
 * @author congt
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffID", query = "SELECT s FROM Staff s WHERE s.staffID = :staffID"),
    @NamedQuery(name = "Staff.findByMail", query = "SELECT s FROM Staff s WHERE s.mail = :mail"),
    @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password"),
    @NamedQuery(name = "Staff.findByName", query = "SELECT s FROM Staff s WHERE s.name = :name"),
    @NamedQuery(name = "Staff.findByDateOfBirth", query = "SELECT s FROM Staff s WHERE s.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Staff.findByTel", query = "SELECT s FROM Staff s WHERE s.tel = :tel"),
    @NamedQuery(name = "Staff.findByPicture", query = "SELECT s FROM Staff s WHERE s.picture = :picture"),
    @NamedQuery(name = "Staff.findByDateOfJoin", query = "SELECT s FROM Staff s WHERE s.dateOfJoin = :dateOfJoin"),
    @NamedQuery(name = "Staff.findByCountry", query = "SELECT s FROM Staff s WHERE s.country = :country"),
    @NamedQuery(name = "Staff.findByCity", query = "SELECT s FROM Staff s WHERE s.city = :city"),
    @NamedQuery(name = "Staff.findByDistrict", query = "SELECT s FROM Staff s WHERE s.district = :district"),
    @NamedQuery(name = "Staff.findByAddress", query = "SELECT s FROM Staff s WHERE s.address = :address")})
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StaffID")
    private Integer staffID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Mail")
    private String mail;
    @Size(max = 45)
    @Column(name = "Password")
    private String password;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 45)
    @Column(name = "tel")
    private String tel;
    @Size(max = 45)
    @Column(name = "Picture")
    private String picture;
    @Column(name = "DateOfJoin")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoin;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "district")
    private String district;
    @Size(max = 45)
    @Column(name = "address")
    private String address;

    public Staff() {
    }

    public Staff(Integer staffID) {
        this.staffID = staffID;
    }

    public Staff(Integer staffID, String mail) {
        this.staffID = staffID;
        this.mail = mail;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffID != null ? staffID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffID == null && other.staffID != null) || (this.staffID != null && !this.staffID.equals(other.staffID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Staff[ staffID=" + staffID + " ]";
    }
    
}
