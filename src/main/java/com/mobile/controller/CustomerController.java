package com.mobile.controller;

import com.mobile.dao.CustomerFacade;
import com.mobile.entity.Customer;
import com.mobile.service.AccountService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable {

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private AccountService accountLogin;
    Customer cus = new Customer();
    private String namecus, message = null,success=null;

    private String mail, password, confirmpass, message2 = null, message1 = null;
    boolean checklogin = false;
    List<Customer> listAll;

    public String create() {
        if (customerFacade.checkMail(cus.getMail()) && cus.getPassword().equals(confirmpass)) {
            customerFacade.create(cus);
            success=null;
            message1 = null;
            message2 = null;
            success = "Successfully";
            return "register.xhtml?faces-redirect=true";
        } else if (customerFacade.checkMail(cus.getMail()) == false) {
            success=null;
            message1 = null;
            message2 = null;
            message2 = "Email was duplicate";
            return "register.xhtml?faces-redirect=true";
        } else if (!cus.getPassword().equals(confirmpass)) {
            success=null;
            message1 = null;
            message2 = null;    
            message1 = "Incorrect Confirm PassWord";
            return "register.xhtml?faces-redirect=true";
        } else {
            success=null;
            message1 = null;
            message2 = null;
            return "register.xhtml?faces-redirect=true";
        }
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public List<Customer> getListAll() {
        listAll = customerFacade.findAll();
        return listAll;
    }

    public void setListAll(List<Customer> listAll) {
        this.listAll = listAll;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String logout() {
        cus = null;
        checklogin = false;
        return "/index.xhtml?faces-redirect=true";
    }

    public String login() {
        cus = accountLogin.Login(mail, password);
        if (cus != null) {
            message = "";
            checklogin = true;
            return "/index.xhtml?faces-redirect=true";
        } else {
            message = "Invalid mail or password";
            return "/login.xhtml?faces-redirect=true";
        }
    }
    public void update(){
        customerFacade.edit(cus);
         FacesMessage msg = new FacesMessage(" Update Successful",null);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public boolean isChecklogin() {
        return checklogin;
    }

    public void setChecklogin(boolean checklogin) {
        this.checklogin = checklogin;
    }

    public AccountService getAccountLogin() {
        return accountLogin;
    }

    public void setAccountLogin(AccountService accountLogin) {
        this.accountLogin = accountLogin;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public String getNamecus() {
        return namecus;
    }

    public void setNamecus(String namecus) {
        this.namecus = namecus;
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

    public CustomerController() {
    }

}
