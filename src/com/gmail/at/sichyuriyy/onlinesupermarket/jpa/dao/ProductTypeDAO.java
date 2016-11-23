package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.ProductType;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProductTypeDAO extends AbstractDAO<ProductType> {

    @Override
    public void create(ProductType type) {
        entityManager.persist(type);
    }

    @Override
    public void delete(long id) {
        ProductType type = entityManager.find(ProductType.class, id);
        if (type.getProducts().size() > 0) {
            return;
        }
        entityManager.remove(type);
    }

    @Override
    public void update(ProductType type) {
        entityManager.merge(type);
    }

    @Override
    public List<ProductType> getAll() {
        List<ProductType> types = entityManager.createNamedQuery("findAllProductTypes", ProductType.class)
                .getResultList();
        return types;
    }

    @Override
    public ProductType getById(long id) {
        return entityManager.find(ProductType.class, id);
    }

}
