/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.dao;

import com.mobile.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author congt
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "ShoppingOnlinePU")
    private EntityManager em;
    List<Customer> list;
    public EntityManager getEm() {
        return em;
    }

    public boolean checkMail(String mail) {
        Query q = em.createNamedQuery("Customer.findByMail");
        q.setParameter("mail", mail);
        list =q.getResultList();
        
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

}
