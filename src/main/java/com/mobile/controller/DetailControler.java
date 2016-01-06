/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;

import com.mobile.dao.DetailFacade;
import com.mobile.entity.Detail;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Liem Nguyen
 */
@Named(value = "detailControler")
@Dependent
public class DetailControler {

    @EJB
    private DetailFacade detailFacade;

    public String addmessage;
    int detailID2;

    Detail d = new Detail();

    public String addDetail() {
        try {            
            detailFacade.create(d);
            return "/staff/manage/AddProduct.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            addmessage = "Invalid Infor";
            return "/staff/manage/detail.xhtml?faces-redirect=true";
        }
    }

    public DetailFacade getDetailFacade() {
        return detailFacade;
    }

    public void setDetailFacade(DetailFacade detailFacade) {
        this.detailFacade = detailFacade;
    }

    public int getDetailID2() {
        return detailID2;
    }

    public void setDetailID2(int detailID2) {
        this.detailID2 = detailID2;
    }

    public String getAddmessage() {
        return addmessage;
    }

    public void setAddmessage(String addmessage) {
        this.addmessage = addmessage;
    }

    public Detail getD() {
        return d;
    }

    public void setD(Detail d) {
        this.d = d;
    }

    public DetailControler() {
    }
}
