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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCusID", query = "SELECT c FROM Customer c WHERE c.cusID = :cusID"),
    @NamedQuery(name = "Customer.findByMail", query = "SELECT c FROM Customer c WHERE c.mail = :mail"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByDateOfBirth", query = "SELECT c FROM Customer c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Customer.findByTel", query = "SELECT c FROM Customer c WHERE c.tel = :tel"),
    @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status"),
    @NamedQuery(name = "Customer.findByPicture", query = "SELECT c FROM Customer c WHERE c.picture = :picture"),
    @NamedQuery(name = "Customer.findByLastaccessdate", query = "SELECT c FROM Customer c WHERE c.lastaccessdate = :lastaccessdate"),
    @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address")})
public class Customer implements Serializable {
    @Size(max = 45)
    @Column(name = "receiveName")
    private String receiveName;
    @Size(max = 45)
    @Column(name = "receiveAddress")
    private String receiveAddress;
    @Size(max = 11)
    @Column(name = "Gender")
    private String gender;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CusID")
    private Integer cusID;
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
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "Picture")
    private String picture;
    @Column(name = "lastaccessdate")
    @Temporal(TemporalType.DATE)
    private Date lastaccessdate;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "cusID")
    private List<Ordertable> ordertableList;

    public Customer() {
    }

    public Customer(Integer cusID) {
        this.cusID = cusID;
    }

    public Customer(Integer cusID, String mail) {
        this.cusID = cusID;
        this.mail = mail;
    }

    public Integer getCusID() {
        return cusID;
    }

    public void setCusID(Integer cusID) {
        this.cusID = cusID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getLastaccessdate() {
        return lastaccessdate;
    }

    public void setLastaccessdate(Date lastaccessdate) {
        this.lastaccessdate = lastaccessdate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Ordertable> getOrdertableList() {
        return ordertableList;
    }

    public void setOrdertableList(List<Ordertable> ordertableList) {
        this.ordertableList = ordertableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusID != null ? cusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cusID == null && other.cusID != null) || (this.cusID != null && !this.cusID.equals(other.cusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Customer[ cusID=" + cusID + " ]";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    
}
