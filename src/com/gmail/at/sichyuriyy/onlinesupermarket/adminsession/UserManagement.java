package com.gmail.at.sichyuriyy.onlinesupermarket.adminsession;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.UserDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.User;

@ManagedBean(name="userManagement")
@SessionScoped
public class UserManagement {
    
    private List<User> allUsers;
    private String userName;
    
    @EJB
    private UserDAO userDAO; 
    
    @PostConstruct
    private void init() {
        allUsers = userDAO.getAll();
    }
    
    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
    
    public List<User> getUsers() {
        return userDAO.getAll();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
}
