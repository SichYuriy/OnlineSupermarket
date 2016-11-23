package com.gmail.at.sichyuriyy.onlinesupermarket.servicebean;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.CustomerDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.RoleDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Customer;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Role;


@ManagedBean(name="customerService")
@ApplicationScoped
public class CustomerServiceBean implements ServiceCRUD<Customer>{

    @EJB 
    private CustomerDAO customerDAO;
    
    @EJB
    private RoleDAO roleDAO;
    
    @Override
    public void create(Customer customer) {
        customerDAO.create(customer);
    }
    
    public void create(String login, String password) {
        Customer customer  = new Customer();
        customer.setLogin(login);
        customer.setPasswd(password);
        List<Role> roles = new LinkedList<>();
        roles.add(roleDAO.getByName("customer"));
        customer.setRoles(roles);
        create(customer);
        
    }

    @Override
    public void delete(long id) {
        customerDAO.delete(id);
    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    public Customer getById(long id) {
        return customerDAO.getById(id);
    }

}
