package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.User;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserDAO extends AbstractDAO<User> {

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery("getAllUsers", User.class).getResultList();
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByLogin(String login) {
        List<User> users = entityManager.createNamedQuery("getUserByLogin", User.class).setParameter("login", login)
                .getResultList();
        if (users == null || users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

}
