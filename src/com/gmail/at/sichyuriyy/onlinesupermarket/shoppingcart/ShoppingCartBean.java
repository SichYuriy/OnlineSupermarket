package com.gmail.at.sichyuriyy.onlinesupermarket.shoppingcart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.bank.BankService;
import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.AccountNotFoundException;
import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.NotEnoughMoneyException;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;

class Purchase {

    Product product;
    double count;

    Purchase(Product product, double count) {
        this.product = product;
        this.count = count;
    }
}

@Stateful
@SessionScoped
@Remote(ShoppingCart.class)
public class ShoppingCartBean implements ShoppingCart, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @EJB
    private BankService bankService;

    private HashMap<Long, Purchase> products;

    private double sum;
    private long shopAccount;

    @PostConstruct
    private void init() {
        products = new HashMap<>();
        sum = 0;
        shopAccount = 1111_1111_1111_1111L; // TODO:

    }

    private double countSum() {
        double sum = 0;
        for (Purchase p : products.values()) {
            sum += p.count * p.product.getPrice();
        }
        return sum;
    }

    @Override
    public void addProduct(Product product, double count) {
        long id = product.getId();
        if (products.containsKey(id)) {
            products.get(id).count += count;
        } else {
            products.put(id, new Purchase(product, count));
        }
        sum += product.getPrice() * count;
    }

    @Override
    public void remove(long productId) {
        products.remove(productId);
        sum = countSum();
    }

    @Override
    public void clear() {
        products.clear();
        sum = 0;
    }

    @Override
    public void buy(long userAccount) throws AccountNotFoundException, NotEnoughMoneyException {

        bankService.transfer(userAccount, shopAccount, sum);

    }

    @Override
    public double getSum() {
        return sum;

    }

    @Override
    public List<Product> getProducts() {

        return products.values().stream().map((purchase) -> purchase.product).collect(Collectors.toList());
    }

    @Override
    public double getCount(long productId) {
        Purchase purchase = products.get(productId);
        if (purchase != null) {
            return purchase.count;
        } else {
            return 0;
        }
    }

    @Override
    public void setCount(long productId, double count) {
        Purchase purchase = products.get(productId);
        if (purchase == null) {
            return;
        }
        if (count == 0) {
            products.remove(productId);
        } else {
            purchase.count = count;
        }
        sum = countSum();

    }

    @Override
    public double getSum(long productId) {
        Purchase purchase = products.get(productId);
        if (purchase == null) {
            return 0;
        }

        return purchase.count * purchase.product.getPrice();
    }

    public List<Purchase> getPurchases() {
        List<Purchase> result = new LinkedList<>();
        for (Purchase p : products.values()) {
            result.add(p);
        }
        
        return result;
    }

}
