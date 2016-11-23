package com.gmail.at.sichyuriyy.onlinesupermarket.usersession;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.ProductDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.ProductTypeDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;

@ManagedBean(name = "productFilter")
@SessionScoped
public class ProductFilter {

    @EJB
    private ProductTypeDAO productTypeDAO;

    @EJB
    private ProductDAO productDAO;

    private LinkedList<ProductTypeItem> productTypeItems;
    private Long productTypeId;
    private String productTypeLabel;
    private String productName;
    private List<Product> allProducts;

    public ProductFilter() {

    }

    @PostConstruct
    private void init() {
        productName = null;
        allProducts = productDAO.getAll();
        productTypeLabel = "All";
        productTypeItems = new LinkedList<>();
        productTypeItems.add(new ProductTypeItem("All", null));

        for (ProductType productType : productTypeDAO.getAll()) {
            productTypeItems.add(new ProductTypeItem(productType.getName(), productType.getId()));
        }
        productTypeId = null;
    }

    public void changeProductType(ProductTypeItem item) {
        productTypeId = item.getId();
        productTypeLabel = item.getName();
    }

    public List<Product> getProducts() {

        List<Product> result = allProducts;

        if (productTypeId != null) {
            result = result.stream().filter((product) -> (product.getProductType().getId() == productTypeId))
                    .collect(Collectors.toList());
        }

        if (productName != null && !productName.trim().equals("")) {
            result = result.stream()
                    .filter((product) -> product.getName().toLowerCase().contains(productName.trim().toLowerCase()))
                    .collect(Collectors.toList());
        }
        return result;
    }

    public ProductTypeDAO getProductTypeDAO() {
        return productTypeDAO;
    }

    public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
        this.productTypeDAO = productTypeDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public LinkedList<ProductTypeItem> getProductTypeItems() {
        return productTypeItems;
    }

    public void setProductTypeItems(LinkedList<ProductTypeItem> productTypeItems) {
        this.productTypeItems = productTypeItems;
    }

    public String getProductTypeLabel() {
        return productTypeLabel;
    }

    public void setProductTypeLabel(String productTypeLabel) {
        this.productTypeLabel = productTypeLabel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
