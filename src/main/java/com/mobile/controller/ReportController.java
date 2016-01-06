/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;

import com.mobile.dao.ReportFacade;
import com.mobile.entity.Report;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Liem Nguyen
 */
@Named(value = "reportController")
@Dependent
public class ReportController {
    @EJB
    private ReportFacade reportFacade;
    Report rp = new Report();
    public void addReport(){
        reportFacade.create(rp);
    }
    public Report getRp() {
        return rp;
    }

    public void setRp(Report rp) {
        this.rp = rp;
    }
    public ReportController() {
    }
    
}
