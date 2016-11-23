package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Role;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RoleDAO extends AbstractDAO<Role> {

    @Override
    public void create(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public List<Role> getAll() {
        return entityManager.createNamedQuery("getAllRoles", Role.class).getResultList();
    }

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }

    public Role getByName(String name) {
        List<Role> roles = entityManager.createNamedQuery("getRoleByName", Role.class).setParameter("name", name)
                .getResultList();
        if (roles == null || roles.size() == 0) {
            return null;
        }
        return roles.get(0);
    }

}
