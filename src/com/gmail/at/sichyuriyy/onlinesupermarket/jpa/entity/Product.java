package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;
    private PriceType priceType;

    @ManyToOne
    @JoinColumn(name = "productType_fk")
    private ProductType productType;

    public Product() {
        super();
    }

    public Product(String name, Double price, String description, PriceType priceType, ProductType productType) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
        this.priceType = priceType;
        this.productType = productType;
    }

    public Product(long id, String name, Double price, String description, PriceType priceType,
            ProductType productType) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.priceType = priceType;
        this.productType = productType;
    }

    public enum PriceType {
        INDIVIDUALY, KILOGRAM
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    

}
