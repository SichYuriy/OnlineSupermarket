package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProductDAO extends AbstractDAO<Product> {

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void delete(long id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = entityManager.createNamedQuery("findAllProducts", Product.class).getResultList();
        return products;
    }

    @Override
    public Product getById(long id) {
        return entityManager.find(Product.class, id);
    }

}
