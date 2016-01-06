/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.service.implement;

import com.mobile.dao.CustomerFacade;
import com.mobile.dao.OrderlineFacade;
import com.mobile.dao.ProductFacade;
import com.mobile.entity.Category;
import com.mobile.entity.Orderline;
import com.mobile.entity.Ordertable;
import com.mobile.entity.Product;
import com.mobile.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class ProductServiceImpl implements ProductService {
    @EJB
    private OrderlineFacade orderlineFacade;
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private ProductFacade productFacade;

    @Override
    public List<Product> findProductByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findProductByCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listBestSellingProduct() {
        String query = "SELECT p FROM Product p ORDER BY p.soldQuantity DESC";
        TypedQuery<Product> typedQuery = productFacade.getEm()
                .createQuery(query, Product.class);
        typedQuery.setMaxResults(8);
        List<Product> products;
        try {
            products = typedQuery.getResultList();
        } catch (Exception e) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    public List<Product> NewProduct() {
        String query = "SELECT p FROM Product p ORDER BY p.publishDate DESC";
        TypedQuery<Product> typedQuery = productFacade.getEm()
                .createQuery(query, Product.class);
        typedQuery.setMaxResults(8);
        List<Product> products;
        try {
            products = typedQuery.getResultList();
        } catch (Exception e) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    public Product findProductByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orderline> findOrderlineByOrdertableID(Ordertable ordertable) {
        String query = "SELECT o FROM Orderline o WHERE o.orderLineID = :orderLineID";
        TypedQuery<Orderline> typeQuery = orderlineFacade.getEm().
                createNamedQuery(query, Orderline.class);
        return typeQuery.getResultList();
       
    }

 

    @Override
    public List<Ordertable> findAllOrdertable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
