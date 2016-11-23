package com.gmail.at.sichyuriyy.onlinesupermarket.servicebean;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.AdminDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.RoleDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Admin;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.Role;


@ManagedBean(name="adminService")
@ApplicationScoped
public class AdminServiceBean implements ServiceCRUD<Admin>{

    @EJB 
    private AdminDAO adminDAO;
    
    @EJB
    private RoleDAO roleDAO;
    
    @Override
    public void create(Admin admin) {
        adminDAO.create(admin);
    }
    
    public void create(String login, String password) {
        Admin admin  = new Admin();
        admin.setLogin(login);
        admin.setPasswd(password);
        List<Role> roles = new LinkedList<>();
        roles.add(roleDAO.getByName("admin"));
        admin.setRoles(roles);
        create(admin);
        
    }

    @Override
    public void delete(long id) {
        adminDAO.delete(id);
    }

    @Override
    public void update(Admin admin) {
        adminDAO.update(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminDAO.getAll();
    }

    @Override
    public Admin getById(long id) {
        return adminDAO.getById(id);
    }

}
