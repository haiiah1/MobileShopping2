package com.mobile.controller;

import com.mobile.dao.StaffFacade;
import com.mobile.entity.Staff;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "staffController")
@SessionScoped
public class StaffController implements Serializable {

    @EJB
    private StaffFacade staffFacade;

    Staff st = new Staff();
    private String mail, password, message, message2;
    List<Staff> listAll;

    public String createStaff() {
        try {
            message2 = "Successful";
            staffFacade.create(st);
            return "/admin/AddStaff.xhtml?faces-redirect=true" ;
        } catch (Exception e) {
            message2 = "Failed";
            return "/admin/AddStaff.xhtml?faces-redirect=true" ;
        }
    }

    public String pretoEdit(int ID) {
        st = staffFacade.find(ID);
        return "/admin/edit.xhtml?faces-redirect=true";
    }

    public void editStaff() {
        staffFacade.edit(st);
    }

    public String logout() {
        st = null;
        return "/staff/StaffLogin.xhtml?faces-redirect=true";
    }

    public String login() {
        st = staffFacade.Login(mail, password);
        if (st != null) {
            message = "";
            return "/staff/index-staff.xhtml?faces-redirect=true";
        } else {
            message = "Invalid mail or password";
            return "/staff/StaffLogin.xhtml?faces-redirect=true";
        }
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public StaffFacade getStaffFacade() {
        return staffFacade;
    }

    public void setStaffFacade(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    public List<Staff> getListAll() {
        return listAll = staffFacade.findAll();
    }

    public void setListAll(List<Staff> listAll) {
        this.listAll = listAll;
    }

    public Staff getSt() {
        return st;
    }

    public void setSt(Staff st) {
        this.st = st;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StaffController() {
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

}
