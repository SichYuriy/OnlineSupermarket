package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Account;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccountDAO extends AbstractDAO<Account> {

    @Override
    public void create(Account account) {
        entityManager.persist(account);
        
    }

    @Override
    public void delete(long id) {
        Account account = entityManager.find(Account.class, id);
        entityManager.remove(account);
        
    }

    @Override
    public void update(Account account) {
        entityManager.merge(account);
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = entityManager.createNamedQuery("findAllAccounts", Account.class).getResultList();
        return accounts;
    }

    @Override
    public Account getById(long id) {
        return entityManager.find(Account.class, id);
    }
    
    public Account getByNumber(long number) {
        List<Account> accounts = entityManager.createNamedQuery("findAccountByNumber", Account.class)
            .setParameter("number", number)
            .getResultList();
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        return accounts.get(0);
    }

}
