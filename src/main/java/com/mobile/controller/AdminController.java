/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;

import com.mobile.dao.AdminFacade;
import com.mobile.entity.Admin;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Thien
 */
@Named(value = "adminController")
@SessionScoped
public class AdminController implements Serializable {

    @EJB
    private AdminFacade adminFacade;

    Admin a = new Admin();
    String username, password, message;

    public String logout() {
        a = null;
        return "/staff/StaffLogin.xhtml?faces-redirect=true";
    }

    public String login() {
        a = adminFacade.Login(username, password);
        if (a != null) {
            message = "";
            return "/admin/AdminIndex.xhtml?faces-redirect=true";
        } else {
            message = "Invalid mail or password";
            return "/admin/AdminLogin.xhtml?faces-redirect=true";
        }
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AdminController() {
    }

}
