package com.gmail.at.sichyuriyy.onlinesupermarket.bank;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.AccountNotFoundException;
import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.NotEnoughMoneyException;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.AccountDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Account;

@Remote(BankService.class)
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BankServiceBean implements BankService {

    @EJB
    private AccountDAO accountDAO;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void transfer(long fromAccountNumber, long toAccountNumber, double amount) throws AccountNotFoundException, NotEnoughMoneyException {
        Account fromAccount = accountDAO.getByNumber(fromAccountNumber);
        Account toAccount = accountDAO.getByNumber(toAccountNumber);
        if (fromAccount == null) {
            throw new AccountNotFoundException("User account is not found");
        }
        if (toAccount == null) {
            throw new AccountNotFoundException("Desteny account is not found");
        }
        
        double userMoney = fromAccount.getMoney();
        if (userMoney < amount) {
            throw new NotEnoughMoneyException();
        }
        
        fromAccount.setMoney(userMoney - amount); 
        toAccount.setMoney(toAccount.getMoney() + amount);
    }

}
