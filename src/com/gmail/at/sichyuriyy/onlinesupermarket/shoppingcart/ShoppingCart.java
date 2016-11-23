package com.gmail.at.sichyuriyy.onlinesupermarket.shoppingcart;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.AccountNotFoundException;
import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.NotEnoughMoneyException;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;

@Remote
@Stateful
public interface ShoppingCart {
    
    public void addProduct(Product product, double count);
    public void remove(long productId);
    public void clear();
    public double getSum();
    public double getSum(long productId);
    public void buy(long userAccount) throws AccountNotFoundException, NotEnoughMoneyException;
    public List<Product> getProducts();
    public double getCount(long productId);
    public void setCount(long productId, double count);

}
