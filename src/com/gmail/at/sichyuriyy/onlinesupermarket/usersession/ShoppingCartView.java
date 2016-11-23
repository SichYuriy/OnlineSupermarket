package com.gmail.at.sichyuriyy.onlinesupermarket.usersession;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.AccountNotFoundException;
import com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions.NotEnoughMoneyException;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Product;
import com.gmail.at.sichyuriyy.onlinesupermarket.shoppingcart.ShoppingCart;

@ManagedBean(name="shoppingCart")
@SessionScoped
public class ShoppingCartView {
    
    private Logger logger;
    
    @EJB
    private ShoppingCart shoppingCart;
    
    
    
    private Double countToAdd;
    private Product productToAdd;
    
    private Double countToEdit;
    private Product productToEdit;
    
    private boolean startPurchase;
    private long userAccount;
    
    
    public ShoppingCartView() {
        
    }
    
    @PostConstruct
    private void init() {
        logger = Logger.getLogger(ShoppingCartView.class);
        productToAdd = null;
        startPurchase = false;
    }
    
    public boolean isProductToAddId(Long productId) {
        if (productToAdd == null || productId == null) {
            return false;
        }
        return productId.equals(productToAdd.getId());
    }
    
    public void startAddProduct(Product product, double count) {
        productToAdd = product;
        countToAdd = count;
    }
    
    public void confirmAddProduct() {
        validateCountToAdd();
        addProduct(productToAdd, countToAdd);
        productToAdd = null;
        countToAdd = 1d;
    }
    
    public void cancelAddProduct() {
        productToAdd = null;
        countToAdd = 1d;
    }
    
    public void validateCountToAdd() {
        logger.info("from validateCountToAdd");
        if (productToAdd.getPriceType() == Product.PriceType.INDIVIDUALY) {
            countToAdd = Math.floor(countToAdd);
        }
        if (countToAdd <= 0) {
            countToAdd = 1d;
        }
    }
    
    public boolean isProductToEditId(Long productId) {
        if (productToEdit == null || productId == null) {
            return false;
        }
        return productId.equals(productToEdit.getId());
    }
    
    public void startEditProduct(Product product) {
        productToEdit = product;
        countToEdit = shoppingCart.getCount(product.getId());
    }
    
    public void confirmEditProduct() {
        validateCountToEdit();
        setCount(productToEdit.getId(), countToEdit);
        productToEdit = null;
    }
    
    public void cancelEditProduct() {
        productToEdit = null;
        countToEdit = 1d;
    }
    
    public void validateCountToEdit() {
        logger.info("from validateCountToEdit");
        if (productToEdit.getPriceType() == Product.PriceType.INDIVIDUALY) {
            countToEdit = Math.floor(countToEdit);
        }
        if (countToEdit <= 0) {
            countToEdit = 1d;
        }
    }
    
    public void inputCardNumber() {
        if (getProducts().size() == 0) {
            return;
        }
        startPurchase = true;
    }
    
    public void cancelPurchase() {
        startPurchase = false;
    }
    
    
    
    
    public void addProduct(Product product, double count) {
        shoppingCart.addProduct(product, count);
    }

    public void remove(long productId) {
        shoppingCart.remove(productId);
    }

    public void clear() {
        shoppingCart.clear();
    }
    
    public double getSum() {
        return shoppingCart.getSum();
    }
    
    public double getSum(long productId) {
        return shoppingCart.getSum(productId);
    }

    public String buy() {
        if (getProducts().size() == 0) {
            startPurchase = false;
            return "emptyCart?facesRedirect=true";
            
        }
        String navigation = "purchaseSuccess?faces-redirect=true";
        boolean success = true;
        try {
            shoppingCart.buy(userAccount);
        } catch (AccountNotFoundException e) {
            logger.error(e);
            navigation = "badAccount?faces-redirect=true";
            success = false;
        } catch (NotEnoughMoneyException e) {
            logger.error(e);
            navigation = "notEnoughMoney?faces-redirect=true";
            success = false;
        }
        if (success) {
            clear();
            startPurchase = false;
        }
        return navigation;
    }

    public List<Product> getProducts() {
        return shoppingCart.getProducts();
    }

    public double getCount(long productId) {
        return shoppingCart.getCount(productId);
    }

    public void setCount(long productId, double count) {
        shoppingCart.setCount(productId, count);
        
    }

    public long getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(long userAccount) {
        this.userAccount = userAccount;
    }

    public Double getCountToAdd() {
        return countToAdd;
    }

    public void setCountToAdd(Double countToAdd) {
        this.countToAdd = countToAdd;
    }

    public Product getProductToAdd() {
        return productToAdd;
    }

    public void setProductToAddId(Product productToAdd) {
        this.productToAdd = productToAdd;
    }

    public Product getProductToEdit() {
        return productToEdit;
    }

    public void setProductToEdit(Product productToEdit) {
        this.productToEdit = productToEdit;
    }

    public void setProductToAdd(Product productToAdd) {
        this.productToAdd = productToAdd;
    }

    public Double getCountToEdit() {
        return countToEdit;
    }

    public void setCountToEdit(Double countToEdit) {
        this.countToEdit = countToEdit;
    }

    public boolean isStartPurchase() {
        return startPurchase;
    }

    public void setStartPurchase(boolean startPurchase) {
        this.startPurchase = startPurchase;
    }

}
