package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Manager;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ManagerDAO extends AbstractDAO<Manager> {

    @Override
    public void create(Manager manager) {
        entityManager.persist(manager);
    }

    @Override
    public void delete(long id) {
        Manager manager = entityManager.find(Manager.class, id);
        entityManager.remove(manager);
    }

    @Override
    public void update(Manager manager) {
        entityManager.merge(manager);
    }

    @Override
    public List<Manager> getAll() {
        return entityManager.createNamedQuery("getAllManagers", Manager.class).getResultList();
    }

    @Override
    public Manager getById(long id) {
        return entityManager.find(Manager.class, id);
    }

}
