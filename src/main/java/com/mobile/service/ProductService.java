/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.service;

import com.mobile.entity.Category;
import com.mobile.entity.Orderline;
import com.mobile.entity.Ordertable;
import com.mobile.entity.Product;
import java.util.List;

/**
 *
 * @author congt
 */
public interface ProductService {

    public List<Product> findProductByName(String name);

    public List<Product> findProductByCategory(Category category);

    public List<Product> listBestSellingProduct();
    
    public List<Product> NewProduct();
    
    public Product findProductByID(String id);
    
    public List<Orderline> findOrderlineByOrdertableID(Ordertable ordertable);
    public List<Ordertable> findAllOrdertable();
}
