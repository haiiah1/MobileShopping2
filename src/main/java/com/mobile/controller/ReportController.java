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
    public Report rpt = new Report();
    public String message="null";
    public String addReport(){
        try{
            reportFacade.create(rpt);
            message="Sucessfully";
            return "Report.xhtml?faces-redirect=true";
        }catch(Exception ex){
            message="False";
            return "Report.xhtml?faces-redirect=true";
        }
    }

    public ReportFacade getReportFacade() {
        return reportFacade;
    }

    public void setReportFacade(ReportFacade reportFacade) {
        this.reportFacade = reportFacade;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Report getRpt() {
        return rpt;
    }

    public void setRpt(Report rpt) {
        this.rpt = rpt;
    }
    public ReportController() {
    }

    public Integer getReportID() {
        return rpt.getReportID();
    }

    public void setReportID(Integer reportID) {
        rpt.setReportID(reportID);
    }

    public String getTitle() {
        return rpt.getTitle();
    }

    public void setTitle(String title) {
        rpt.setTitle(title);
    }

    public String getContent() {
        return rpt.getContent();
    }

    public void setContent(String content) {
        rpt.setContent(content);
    }

    public String getEmail() {
        return rpt.getEmail();
    }

    public void setEmail(String email) {
        rpt.setEmail(email);
    }

    public String getStatus() {
        return rpt.getStatus();
    }

    public void setStatus(String status) {
        rpt.setStatus(status);
    }
    
}
