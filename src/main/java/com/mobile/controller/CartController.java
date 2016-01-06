/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.controller;

import com.mobile.dao.OrderlineFacade;
import com.mobile.dao.OrdertableFacade;
import com.mobile.dao.ProductFacade;
import com.mobile.entity.Customer;
import com.mobile.entity.Orderline;
import com.mobile.entity.Ordertable;
import com.mobile.entity.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author congt
 */
@Named(value = "cartController")
@SessionScoped
public class CartController implements Serializable {
    
    @EJB
    private OrderlineFacade orderlineFacade;
    
    @EJB
    private OrdertableFacade ordertableFacade;
    @EJB
    private ProductFacade productFacade;
    
    @Inject
    ProductController pro;
    @Inject
    CustomerController customerController;
    private float totalPrice;
    String color = "White";
    int buyQuantity = 1;
    List<Orderline> OrderLineList = new ArrayList<>();
    List<Ordertable> ordertablelist = null;
    private Orderline orderline = null;
    private Ordertable ordertable = null;
    private Product product;
    private int activeTabIndex = 0;
    private int orderid = 1;
    
    private String currentStepID = "customer";
    
    public CartController() {
        this.pro = new ProductController();
        OrderLineList = new ArrayList<>();
        ordertable = new Ordertable();
//          orderline = new Orderline();
    }
    
    public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public boolean checkProductDuplication(Product p, Orderline orderline) {
        
        for (int i = 0; i < OrderLineList.size(); i++) {
            if (OrderLineList.get(i).getProductID().equals(orderline.getProductID())
                    && OrderLineList.get(i).getColor().equals(orderline.getColor())) {
                OrderLineList.get(i).setQuantity(
                        buyQuantity + OrderLineList.get(i).getQuantity());
//                OrderLineList.get(i).setUnitprice(
//                 OrderLineList.get(i).getUnitprice() *  OrderLineList.get(i).getQuantity());
                return true;
            }
            
        }
        return false;
    }
    
    public void addtoCart(Product p) {
        Orderline order = new Orderline();
        order.setProductID(p);
        order.setColor(color);
        order.setQuantity(buyQuantity);
        order.setUnitprice(p.getUnitPrice());
        if (!checkProductDuplication(p, order)) {
            
            OrderLineList.add(order);
        }
        totalPrice = totalPrice();
        FacesMessage msg = new FacesMessage("Successful",
                "Added " + p.getName() + " " + color + " to cart ");
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public float totalPrice() {
        float total = 0;
        for (Orderline OrderLine : OrderLineList) {
            total += OrderLine.getUnitprice() * OrderLine.getQuantity();
        }
        return total;
    }
    
    public void updateCart() {
        totalPrice = totalPrice();
    }
    
    public String removeAll() {
        OrderLineList = new ArrayList<>();
        totalPrice = 0;
        return "/service/cart.xhtml?faces-redirect=true";
    }
    
    public String saveOrder(Customer customer) {
        int i = 1;
        Ordertable o = new Ordertable();
        int orderID = rand(0, 2000000000);
        o.setOrderID(orderID);
        o.setCusID(customer);
        o.setTotalPrice(totalPrice);
        o.setReceiveName(customer.getReceiveName());
        o.setReceiveAddress(customer.getReceiveAddress());
        o.setOrderDate(new Date());
        o.setStatus("new");
        ordertableFacade.create(o);
        for (Orderline ol : OrderLineList) {
            int orderlineID = rand(0, 2000000000);
            ol.setOrderLineID(orderlineID);
            ol.setOrdertableOrderNumber(o);
            orderlineFacade.create(ol);
            
        }
        OrderLineList = new ArrayList<>();
        return "successPayment.xhtml?faces-redirect=true;";
    }
    
    public OrdertableFacade getOrdertableFacade() {
        return ordertableFacade;
    }
    
    public void setOrdertableFacade(OrdertableFacade ordertableFacade) {
        this.ordertableFacade = ordertableFacade;
    }
    
    public ProductFacade getProductFacade() {
        return productFacade;
    }
    
    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }
    
    public ProductController getPro() {
        return pro;
    }
    
    public void setPro(ProductController pro) {
        this.pro = pro;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getBuyQuantity() {
        return buyQuantity;
    }
    
    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getActiveTabIndex() {
        return activeTabIndex;
    }
    
    public void setActiveTabIndex(int activeTabIndex) {
        this.activeTabIndex = activeTabIndex;
    }
    
    public String getCurrentStepID() {
        return currentStepID;
    }
    
    public void setCurrentStepID(String currentStepID) {
        this.currentStepID = currentStepID;
    }
    
    public List<Orderline> getOrderLineList() {
        
        return OrderLineList;
    }
    
    public Orderline getOrderline() {
//        if(orderline == null)
//            orderline = new Orderline();
        return orderline;
    }
    
    public void setOrderline(Orderline orderline) {
        this.orderline = orderline;
    }
    
    public void setOrderLineList(List<Orderline> OrderLineList) {
        this.OrderLineList = OrderLineList;
    }
    
    public float getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String onFlowProcess(FlowEvent event) {
        try {
            setActiveIndex(event.getNewStep());
            System.out.println("ID" + activeTabIndex);
            return event.getNewStep();
        } catch (Exception e) {
            return event.getOldStep();
        }
    }
    
    public void setActiveIndex(String stepName) {
        currentStepID = stepName;
        if (stepName.equals("customer")) {
            activeTabIndex = 0;
        } else if (stepName.equals("personal")) {
            activeTabIndex = 1;
        } else {
            activeTabIndex = 2;
        }
        
    }
    
    public boolean isDisableBackButton() {
        return activeTabIndex == 0;
    }
    
    public boolean isDisableNextButton() {
        return activeTabIndex == 2;
    }
    
    public OrderlineFacade getOrderlineFacade() {
        return orderlineFacade;
    }
    
    public void setOrderlineFacade(OrderlineFacade orderlineFacade) {
        this.orderlineFacade = orderlineFacade;
    }
    
    public List<Ordertable> getOrdertablelist() {
        ordertablelist = ordertableFacade.findAll();
        return ordertablelist;
    }
    
    public void setOrdertablelist(List<Ordertable> ordertablelist) {
        this.ordertablelist = ordertablelist;
    }
    
}
