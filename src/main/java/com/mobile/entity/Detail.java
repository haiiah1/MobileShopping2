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
 * @author Thien
 */
@Entity
@Table(name = "detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detail.findAll", query = "SELECT d FROM Detail d"),
    @NamedQuery(name = "Detail.findByDetailID", query = "SELECT d FROM Detail d WHERE d.detailID = :detailID"),
    @NamedQuery(name = "Detail.findByScreen", query = "SELECT d FROM Detail d WHERE d.screen = :screen"),
    @NamedQuery(name = "Detail.findByCamera", query = "SELECT d FROM Detail d WHERE d.camera = :camera"),
    @NamedQuery(name = "Detail.findByCpu", query = "SELECT d FROM Detail d WHERE d.cpu = :cpu"),
    @NamedQuery(name = "Detail.findByVga", query = "SELECT d FROM Detail d WHERE d.vga = :vga"),
    @NamedQuery(name = "Detail.findByRam", query = "SELECT d FROM Detail d WHERE d.ram = :ram"),
    @NamedQuery(name = "Detail.findByPin", query = "SELECT d FROM Detail d WHERE d.pin = :pin"),
    @NamedQuery(name = "Detail.findByConnection", query = "SELECT d FROM Detail d WHERE d.connection = :connection"),
    @NamedQuery(name = "Detail.findBySimSlot", query = "SELECT d FROM Detail d WHERE d.simSlot = :simSlot"),
    @NamedQuery(name = "Detail.findByGuarantee", query = "SELECT d FROM Detail d WHERE d.guarantee = :guarantee"),
    @NamedQuery(name = "Detail.findByInternalstorage", query = "SELECT d FROM Detail d WHERE d.internalstorage = :internalstorage")})
public class Detail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetailID")
    private Integer detailID;
    @Size(max = 45)
    @Column(name = "Screen")
    private String screen;
    @Size(max = 45)
    @Column(name = "Camera")
    private String camera;
    @Size(max = 45)
    @Column(name = "CPU")
    private String cpu;
    @Size(max = 45)
    @Column(name = "VGA")
    private String vga;
    @Size(max = 45)
    @Column(name = "Ram")
    private String ram;
    @Size(max = 45)
    @Column(name = "Pin")
    private String pin;
    @Size(max = 45)
    @Column(name = "Connection")
    private String connection;
    @Size(max = 45)
    @Column(name = "SimSlot")
    private String simSlot;
    @Size(max = 45)
    @Column(name = "Guarantee")
    private String guarantee;
    @Size(max = 10)
    @Column(name = "Internalstorage")
    private String internalstorage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detailDetailID")
    private List<Product> productList;

    public Detail() {
    }

    public Detail(Integer detailID) {
        this.detailID = detailID;
    }

    public Integer getDetailID() {
        return detailID;
    }

    public void setDetailID(Integer detailID) {
        this.detailID = detailID;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getSimSlot() {
        return simSlot;
    }

    public void setSimSlot(String simSlot) {
        this.simSlot = simSlot;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getInternalstorage() {
        return internalstorage;
    }

    public void setInternalstorage(String internalstorage) {
        this.internalstorage = internalstorage;
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
        hash += (detailID != null ? detailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detail)) {
            return false;
        }
        Detail other = (Detail) object;
        if ((this.detailID == null && other.detailID != null) || (this.detailID != null && !this.detailID.equals(other.detailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobile.entity.Detail[ detailID=" + detailID + " ]";
    }
    
}
