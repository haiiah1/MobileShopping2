/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;

import com.mobile.dao.AdvertisementFacade;
import com.mobile.entity.Advertisement;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author congt
 */
@Named(value = "advertisementController")
@SessionScoped
public class AdvertisementController implements Serializable {

    @EJB
    private AdvertisementFacade advertisementFacade;

    private List<Advertisement> items = null;
    private Advertisement selected;

    public AdvertisementController() {
    }

    public AdvertisementFacade getAdvertisementFacade() {
        return advertisementFacade;
    }

    public void setAdvertisementFacade(AdvertisementFacade advertisementFacade) {
        this.advertisementFacade = advertisementFacade;
    }

    public List<Advertisement> getItems() {
        if(items == null)
            items = getAdvertisementFacade().findAll();
        return items;
    }

    public void setItems(List<Advertisement> items) {
        this.items = items;
    }

    public Advertisement getSelected() {
        return selected;
    }

    public void setSelected(Advertisement selected) {
        this.selected = selected;
    }

}
