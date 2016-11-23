package com.gmail.at.sichyuriyy.onlinesupermarket.bank.exceptions;

public class AccountNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public AccountNotFoundException() {
        super();
    }
    
    public AccountNotFoundException(String message) {
        super(message);
    }

}
