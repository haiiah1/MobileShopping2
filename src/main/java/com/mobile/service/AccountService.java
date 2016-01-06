package com.mobile.service;

import com.mobile.dao.CustomerFacade;
import com.mobile.entity.Customer;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class AccountService {

    Customer cus = new Customer();
    @EJB
    private CustomerFacade customerFacade;

    public Customer Login(String mail, String password) {
        String q = "SELECT c FROM Customer c WHERE c.mail = :mail AND c.password = :password";
        TypedQuery<Customer> query = customerFacade.getEm()
                .createQuery(q, Customer.class);
        query.setParameter("mail", mail);
        query.setParameter("password", password);
        try {
            cus = query.getSingleResult();
            return cus;
        } catch (Exception e) {
            return null;
        }
    }
}
