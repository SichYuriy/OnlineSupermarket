package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ProductType
 *
 */
@Entity
@Table(name = "producttypes")
@NamedQuery(name = "findAllProductTypes", query = "SELECT p FROM ProductType p")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;

    public ProductType() {
        super();
    }

    public ProductType(String name, List<Product> products) {
        super();
        this.name = name;
        this.products = products;
    }

    public ProductType(long id, String name, List<Product> products) {
        super();
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
