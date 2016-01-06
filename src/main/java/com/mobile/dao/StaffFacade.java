/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.dao;

import com.mobile.entity.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author congt
 */
@Stateless
public class StaffFacade extends AbstractFacade<Staff> {
    @PersistenceContext(unitName = "ShoppingOnlinePU")
    private EntityManager em;
    Staff s = new Staff();
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffFacade() {
        super(Staff.class);
    }
    
    public Staff Login(String mail, String password) {
        String q = "SELECT s FROM Staff s WHERE s.mail = :mail AND s.password = :password";
        TypedQuery<Staff> query = em
                .createQuery(q, Staff.class);
        query.setParameter("mail", mail);
        query.setParameter("password", password);
        try {
            s = query.getSingleResult();
            return s;
        } catch (Exception e) {
            return null;
        }
    }
}
