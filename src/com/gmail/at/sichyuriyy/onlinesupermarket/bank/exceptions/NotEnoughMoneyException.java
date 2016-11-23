package com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions;

public class NotEnoughMoneyException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public NotEnoughMoneyException() {
        super();
    }
    
    public NotEnoughMoneyException(String message) {
        super(message);
    }

}
