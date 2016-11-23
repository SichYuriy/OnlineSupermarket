package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NamedQueries({
    @NamedQuery(name="getRoleByName", query="SELECT r FROM Role r WHERE r.name=:name"),
    @NamedQuery(name="getAllRoles", query="SELECT r FROM Role r")
})

public class Role {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", unique = true)
    private String name;
    
    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Role() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
