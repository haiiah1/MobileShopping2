/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;

import com.mobile.dao.CategoryFacade;
import com.mobile.dao.DetailFacade;
import com.mobile.dao.ProductFacade;
import com.mobile.entity.Category;
import com.mobile.entity.Detail;
import com.mobile.entity.Product;
import com.mobile.service.ProductService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private DetailFacade detailFacade;

    @EJB
    private CategoryFacade categoryFacade;

    @EJB
    private ProductFacade productFacade;

    @EJB
    private ProductService productService;

    Product p = new Product();
    Category c = new Category();
    Detail d = new Detail();
    List<Product> list = null;
    List<Product> listnew = null;
    List<Product> ListSearch;
    List<Category> ListCate;
    List<Product> listmenu;
    String name, manufacturer, catename, addmessage;
    int categoryID,detailID;
    float unit1, unit2;

    public String addProduct() {
        try {
            c = categoryFacade.find(categoryID);
            d = detailFacade.find(detailID);
            p.setCategoryID(c);
            p.setDetailDetailID(d);
            productFacade.create(p);
            addmessage = "Successfully";
            return "/staff/manage/AddProduct.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            addmessage = "Invalid Infor";
            return "/staff/manage/AddProduct.xhtml?faces-redirect=true";
        }
    }
    public List<Product> searchMenu(String manuf){
        return listmenu=productFacade.searchMenuf(manuf);
    }
    public List<Category> getListCate() {
        ListCate = categoryFacade.findAll();
        return ListCate;
    }

    public String searchProductByCategory(int categoryid) {
        c = categoryFacade.find(categoryid);
        ListSearch = productFacade.searchProductCategory(c);
        return "/staff/StaffList.xhtml?faces-redirect=true";
    }

    public String searchProduct2() {
        c = categoryFacade.find(categoryID);
        ListSearch = productFacade.searchProductss(c, manufacturer, unit1, unit2);
        return "/service/listProduct.xhtml?faces-redirect=true";
    }

    public String searchProductStaff() {
        ListSearch = productFacade.searchByName(name);
        return "/staff/StaffList.xhtml?faces-redirect=true";
    }

    public String searchProduct() {
        ListSearch = productFacade.searchByName(name);
        return "/service/listProduct.xhtml?faces-redirect=true";
    }

    public List<Product> getListmenu() {
        return listmenu;
    }

    public void setListmenu(List<Product> listmenu) {
        this.listmenu = listmenu;
    }

    public DetailFacade getDetailFacade() {
        return detailFacade;
    }

    public void setDetailFacade(DetailFacade detailFacade) {
        this.detailFacade = detailFacade;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getListnew() {
        return listnew;
    }

    public void setListnew(List<Product> listnew) {
        this.listnew = listnew;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    

    public String findProductStaff(int id) {
        p = productFacade.find(id);
        return "/staff/productDetail.xhtml?faces-redirect=true";
    }

    public String findProduct(int id) {
        p = productFacade.find(id);
        return "/productDetail.xhtml?faces-redirect=true";
    }

    public List<Product> listmost() {
        list = productService.listBestSellingProduct();
        return list;
    }

    public List<Product> listnewProduct() {
        listnew = productService.NewProduct();
        return listnew;
    }

    public void setListCate(List<Category> ListCate) {
        this.ListCate = ListCate;
    }

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }

    public void setCategoryFacade(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    public List<Product> getListSearch() {
        return ListSearch;
    }

    public void setListSearch(List<Product> ListSearch) {
        this.ListSearch = ListSearch;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnit1() {
        return unit1;
    }

    public void setUnit1(float unit1) {
        this.unit1 = unit1;
    }

    public float getUnit2() {
        return unit2;
    }

    public void setUnit2(float unit2) {
        this.unit2 = unit2;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public List<Product> getList() {
        list = getProductFacade().findAll();
        return list;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public void create(Product entity) {
        productFacade.create(entity);
    }

    public void edit(Product entity) {
        productFacade.edit(entity);
    }

    public void remove(Product entity) {
        productFacade.remove(entity);
    }

    public Product find(Object id) {
        return productFacade.find(id);
    }

    public List<Product> findAll() {
        return productFacade.findAll();
    }

    public List<Product> findRange(int[] range) {
        return productFacade.findRange(range);
    }

    public int count() {
        return productFacade.count();
    }

    public ProductController() {
    }

    public String getAddmessage() {
        return addmessage;
    }

    public void setAddmessage(String addmessage) {
        this.addmessage = addmessage;
    }

    public Detail getD() {
        return d;
    }

    public void setD(Detail d) {
        this.d = d;
    }

}
