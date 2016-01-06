/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.dao;

import com.mobile.entity.Accessory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author congt
 */
@Stateless
public class AccessoryFacade extends AbstractFacade<Accessory> {
    @PersistenceContext(unitName = "ShoppingOnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccessoryFacade() {
        super(Accessory.class);
    }
    
}
