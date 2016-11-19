package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product.PriceType;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;

@ManagedBean(name="productDTO")
@RequestScoped
public class ProductDTO {

    private long id;

    private String name;
    private double price;
    private String description;
    private Product.PriceType priceType;
    private ProductType productType;
    private long productTypeId;
    
    private Product.PriceType ind = Product.PriceType.INDIVIDUALY;
    private Product.PriceType kg = Product.PriceType.KILOGRAM;

    public ProductDTO() {

    }

    public ProductDTO(long id, String name, Double price, String description, PriceType priceType,
            ProductType productType) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.priceType = priceType;
        this.productType = productType;
        this.productTypeId = productType.getId();
    }

    public ProductDTO(String name, Double price, String description, PriceType priceType, ProductType productType) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
        this.priceType = priceType;
        this.productType = productType;
        this.productTypeId = productType.getId();

    }

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getPriceType(),
                product.getProductType());
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product.PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(Product.PriceType priceType) {
        this.priceType = priceType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Product.PriceType getKg() {
        return kg;
    }

    public void setKg(Product.PriceType kg) {
        this.kg = kg;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product.PriceType getInd() {
        return ind;
    }

    public void setInd(Product.PriceType ind) {
        this.ind = ind;
    }

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

}
