package com.gmail.at.sichyuriyy.onlinesupermarket.registration;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.UserDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.servicebean.AdminServiceBean;
import com.gmail.at.sichyuriyy.onlinesupermarket.servicebean.CustomerServiceBean;
import com.gmail.at.sichyuriyy.onlinesupermarket.servicebean.ManagerServiceBean;

@ManagedBean(name="registrationBean")
@SessionScoped
public class RegistrationBean {
    
    private String login;
    private String password;
    
    private boolean correctLogin;
    
    private Logger logger;
    
    @EJB
    private UserDAO userDAO;
    
    @ManagedProperty(value="#{customerService}")
    private CustomerServiceBean customerService;
    
    @ManagedProperty(value="#{adminService}")
    private AdminServiceBean adminService;
    
    @ManagedProperty(value="#{managerService}")
    private ManagerServiceBean managerService;
    
    @PostConstruct
    private void init() {
        logger = Logger.getLogger(RegistrationBean.class);
    }
    
    public String createCustomer() {
        if (correctLogin) {
            logger.info("correctLogin");
            customerService.create(login, password);
            return "welcome?faces-redirect=true";
        }
        return null;
    }
    
    public String addCustomer() {
        if (correctLogin) {
            logger.info("correctLogin");
            customerService.create(login, password);
            login = null;
            password = null;
            return "userManagement?faces-redirect=true";
        }
        return null;
    }
    
    public String addAdmin() {
        if (correctLogin) {
            logger.info("correctLogin");
            adminService.create(login, password);
            login = null;
            password = null;
            return "userManagement?faces-redirect=true";
        }
        return null;
    }
    
    public String addManager() {
        if (correctLogin) {
            logger.info("correctLogin");
            managerService.create(login, password);
            login = null;
            password = null;
            return "userManagement?faces-redirect=true";
        }
        return null;
    }
    
    public void checkLogin() {
        logger.info("checkLogin");
        if (login == null || login == "") {
            correctLogin = false;
            return;
        }
        if (userDAO.getUserByLogin(login) == null) {
            correctLogin = true;
            return;
        }
        correctLogin = false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCorrectLogin() {
        return correctLogin;
    }

    public void setCorrectLogin(boolean correctLogin) {
        this.correctLogin = correctLogin;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public CustomerServiceBean getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerServiceBean customerService) {
        this.customerService = customerService;
    }

    public AdminServiceBean getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminServiceBean adminService) {
        this.adminService = adminService;
    }

    public ManagerServiceBean getManagerService() {
        return managerService;
    }

    public void setManagerService(ManagerServiceBean managerService) {
        this.managerService = managerService;
    }
    

}
