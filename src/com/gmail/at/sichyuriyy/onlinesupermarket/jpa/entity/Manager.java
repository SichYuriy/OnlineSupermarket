package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Manager
 *
 */
@Entity
@DiscriminatorValue(value="MANAGER")
@NamedQuery(name="getAllManagers", query="SELECT m FROM Manager m")
public class Manager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Manager() {
		super();
	}
   
}
