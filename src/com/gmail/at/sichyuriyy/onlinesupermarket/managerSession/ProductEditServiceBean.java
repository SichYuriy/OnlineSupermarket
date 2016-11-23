package com.gmail.at.sichyuriyy.onlinesupermarket.managersession;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto.ProductDTO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto.ProductTypeDTO;

@ManagedBean(name="productEditService")
@SessionScoped
public class ProductEditServiceBean {
    
    private ProductDTO productDTO;
    private ProductTypeDTO productTypeDTO;
    
    
    public String startEditProduct(Product product) {
        productDTO = new ProductDTO(product);
        return "editProduct?faces-redirect=true";
    }
    
    public String startEditProductType(ProductType productType) {
        productTypeDTO = new ProductTypeDTO(productType);
        return "editProductType?faces-redirect=true";
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ProductTypeDTO getProductTypeDTO() {
        return productTypeDTO;
    }

    public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
        this.productTypeDTO = productTypeDTO;
    }
    
    

}
