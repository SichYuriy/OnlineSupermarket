package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@DiscriminatorValue(value = "CUSTOMER")
@NamedQuery(name = "getAllCustomers", query = "SELECT c FROM Customer c")
public class Customer extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToMany()
    @JoinTable(name = "customer_products", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = {
            @JoinColumn(name = "product_id") })
    private List<Product> products;

    public Customer() {
        super();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
