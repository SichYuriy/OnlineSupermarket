package com.gmail.at.sichyuriyy.onlinesupermarket.servicebean;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.ManagerDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.RoleDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Manager;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Role;


@ManagedBean(name="managerService")
@ApplicationScoped
public class ManagerServiceBean implements ServiceCRUD<Manager>{

    @EJB 
    private ManagerDAO managerDAO;
    
    @EJB
    private RoleDAO roleDAO;
    
    @Override
    public void create(Manager manager) {
        managerDAO.create(manager);
    }
    
    public void create(String login, String password) {
        Manager manager  = new Manager();
        manager.setLogin(login);
        manager.setPasswd(password);
        List<Role> roles = new LinkedList<>();
        roles.add(roleDAO.getByName("manager"));
        manager.setRoles(roles);
        create(manager);
        
    }

    @Override
    public void delete(long id) {
        managerDAO.delete(id);
    }

    @Override
    public void update(Manager manager) {
        managerDAO.update(manager);
    }

    @Override
    public List<Manager> getAll() {
        return managerDAO.getAll();
    }

    @Override
    public Manager getById(long id) {
        return managerDAO.getById(id);
    }

}
