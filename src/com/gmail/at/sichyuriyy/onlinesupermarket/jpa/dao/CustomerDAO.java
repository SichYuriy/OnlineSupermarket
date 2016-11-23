package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Customer;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CustomerDAO extends AbstractDAO<Customer> {

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void delete(long id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public List<Customer> getAll() {
        return entityManager.createNamedQuery("getAllCustomers", Customer.class).getResultList();
    }

    @Override
    public Customer getById(long id) {
        return entityManager.find(Customer.class, id);
    }

}
