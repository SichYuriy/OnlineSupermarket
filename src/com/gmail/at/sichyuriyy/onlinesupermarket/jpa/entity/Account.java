package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@Table(name="accounts")
@NamedQueries({
    @NamedQuery(name = "findAllAccounts", query = "SELECT a FROM Account a"),
    @NamedQuery(name="findAccountByNumber", query="SELECT a FROM Account a WHERE a.number=:number")
})
public class Account implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private long number;
	private double money;

	public Account() {
		super();
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
   
}
