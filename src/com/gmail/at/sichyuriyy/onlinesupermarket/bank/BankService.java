package com.gmail.at.sichyuriyy.onlinesupermarket.bank;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.AccountNotFoundException;
import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.NotEnoughMoneyException;

@Remote
@Stateless
public interface BankService {

    public void transfer(long fromAccountNumber, long toAccountNumber, double amount) 
            throws AccountNotFoundException, NotEnoughMoneyException;

}
