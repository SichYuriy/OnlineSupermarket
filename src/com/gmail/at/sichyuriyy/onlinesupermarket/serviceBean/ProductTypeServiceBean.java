package com.gmail.at.sichyuriyy.onlinesupermarket.serviceBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.ProductTypeDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto.ProductTypeDTO;


@ManagedBean(name="productTypeService")
@RequestScoped
public class ProductTypeServiceBean implements ServiceCRUD<ProductType> {
    
    @EJB
    private ProductTypeDAO productTypeDAO;

    @Override
    public void create(ProductType productType) {
        productTypeDAO.create(productType);
    }

    @Override
    public void delete(long id) {
        productTypeDAO.delete(id);
    }

    @Override
    public void update(ProductType productType) {
        productTypeDAO.update(productType);
    }

    @Override
    public List<ProductType> getAll() {
        return productTypeDAO.getAll();
    }

    @Override
    public ProductType getById(long id) {
        return productTypeDAO.getById(id);
    }

    public String create(ProductTypeDTO productTypeDTO) {
        ProductType productType = new ProductType(
                productTypeDTO.getName(),
                null);
        create(productType);
        return "tableProductTypes?faces-redirect=true"; //TODO:
        
    }

    public String update(ProductTypeDTO productTypeDTO) {
        ProductType productType = productTypeDAO.getById(productTypeDTO.getId());
        productType.setName(productTypeDTO.getName());
        update(productType);
        return "tableProductTypes?faces-redirect=true"; //TODO:
    }

    public ProductTypeDAO getProductTypeDAO() {
        return productTypeDAO;
    }

    public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
        this.productTypeDAO = productTypeDAO;
    }

}
