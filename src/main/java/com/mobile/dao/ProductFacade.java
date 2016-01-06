/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.dao;

import com.mobile.entity.Category;
import com.mobile.entity.Product;
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
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "ShoppingOnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Product> searchMenuf(String manuf){
        Query q= em.createNamedQuery("Product.findByManufacturer");
        q.setParameter("manufacturer", manuf);
        return q.getResultList();
    }
    public List<Product> searchByName(String name) {
        Query q = em.createNamedQuery("Product.findByName");
        q.setParameter("name", "%" + name + "%");
        return q.getResultList();
    }

    public List<Product> searchProductCategory(Category c) {
        String phone = "Select p from Product p"
                + " WHERE p.categoryID = :categoryID ";
        TypedQuery p = em.createQuery(phone, Product.class);
        p.setParameter("categoryID", c);
        return p.getResultList();
    }

    public List<Product> searchProductss(Category c, String manufacturer, float unitprice1, float unitprice2) {        
        String search = "Select p from Product p"
                + " WHERE p.categoryID = :categoryID AND p.manufacturer = :manufacturer"
                + " AND p.unitPrice between :unitPrice1 AND :unitPrice2 GROUP BY p.categoryID";
        TypedQuery s = em.createQuery(search, Product.class);
        s.setParameter("categoryID", c);
        s.setParameter("manufacturer", manufacturer);
        s.setParameter("unitPrice1", unitprice1);
        s.setParameter("unitPrice2", unitprice2);

        return s.getResultList();

    }
    
    public ProductFacade() {
        super(Product.class);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
