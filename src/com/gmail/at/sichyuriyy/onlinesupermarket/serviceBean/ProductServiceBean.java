package com.gmail.at.sichyuriyy.onlinesupermarket.servicebean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.ProductDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.ProductTypeDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto.ProductDTO;

@ManagedBean(name="productService")
@RequestScoped
public class ProductServiceBean implements ServiceCRUD<Product> {

    @EJB
    private ProductDAO productDAO;
    
    @EJB
    private ProductTypeDAO productTypeDAO;

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public void delete(long id) {
        productDAO.delete(id);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);

    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product getById(long id) {
        return productDAO.getById(id);
    }

    public String create(ProductDTO productDTO) {
        ProductType productType = productTypeDAO.getById(productDTO.getProductTypeId());
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(),
                productDTO.getPriceType(), productType);
        create(product);
        return "tableProducts?faces-redirect=true"; // TODO:

    }

    public String update(ProductDTO productDTO) {
        Product product = productDAO.getById(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setPriceType(productDTO.getPriceType());
        product.setProductType(productDTO.getProductType());
        update(product);
        return "tableProducts?faces-redirect=true"; // TODO:
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

}
