/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.dao;

import com.mobile.entity.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author congt
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "ShoppingOnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    Admin a = new Admin();

    public Admin Login(String username, String password) {
        String q = "SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password";
        TypedQuery<Admin> query = em
                .createQuery(q, Admin.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            a = query.getSingleResult();
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    public AdminFacade() {
        super(Admin.class);
    }

}
