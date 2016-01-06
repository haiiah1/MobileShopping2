/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;


import com.mobile.dao.OrderlineFacade;
import com.mobile.dao.OrdertableFacade;
import com.mobile.entity.Ordertable;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author congt
 */
@Named(value = "ordertableController")
@SessionScoped
public class OrdertableController implements Serializable {
    @EJB
    private OrderlineFacade orderlineFacade;
    @EJB
    private OrdertableFacade ordertableFacade;
    private List<Ordertable> ordertablelist = null;
    
    public OrdertableController() {
    }

    public OrderlineFacade getOrderlineFacade() {
        return orderlineFacade;
    }

    public void setOrderlineFacade(OrderlineFacade orderlineFacade) {
        this.orderlineFacade = orderlineFacade;
    }

    public OrdertableFacade getOrdertableFacade() {
        return ordertableFacade;
    }

    public void setOrdertableFacade(OrdertableFacade ordertableFacade) {
        this.ordertableFacade = ordertableFacade;
    }

    public List<Ordertable> getOrdertablelist() {
        return ordertablelist;
    }

    public void setOrdertablelist(List<Ordertable> ordertablelist) {
        this.ordertablelist = ordertablelist;
    }

   

}
