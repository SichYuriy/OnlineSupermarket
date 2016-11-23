package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Admin;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AdminDAO extends AbstractDAO<Admin> {

    @Override
    public void create(Admin admin) {
        entityManager.persist(admin);
    }

    @Override
    public void delete(long id) {
        Admin admin = entityManager.find(Admin.class, id);
        entityManager.remove(admin);
    }

    @Override
    public void update(Admin admin) {
        entityManager.merge(admin);
    }

    @Override
    public List<Admin> getAll() {
        return entityManager.createNamedQuery("getAllAdmins", Admin.class).getResultList();
    }

    @Override
    public Admin getById(long id) {
        return entityManager.find(Admin.class, id);
    }

}
