package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;


@ManagedBean(name="productTypeDTO")
@RequestScoped
public class ProductTypeDTO {

    private Long id;
    private String name;
    private List<Product> products;
    
    public ProductTypeDTO() {

    }

    public ProductTypeDTO(String name, List<Product> products) {
        super();
        this.name = name;
        this.products = products;
    }

    public ProductTypeDTO(Long id, String name, List<Product> products) {
        super();
        this.id = id;
        this.name = name;
        this.products = products;
    }
    
    public ProductTypeDTO(ProductType type) {
        this(type.getId(), type.getName(), type.getProducts());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
