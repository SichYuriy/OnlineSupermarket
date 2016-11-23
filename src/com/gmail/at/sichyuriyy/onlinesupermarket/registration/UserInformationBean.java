package com.gmail.at.sichyuriyy.onlinesupermarket.registration;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.dao.UserDAO;
import com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entity.User;

@ManagedBean(name="userInformation")
@RequestScoped
public class UserInformationBean {
    
    private User user;
    private boolean guest;
    
    @EJB
    private UserDAO userDAO; 
    
    
    @PostConstruct
    public void init() {
       String userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
       if (userName != null) {
           user = userDAO.getUserByLogin(userName);
       } else {
           guest = true;
       }
       
    }
    
    
    
    public boolean isInRole(String role) {
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role);
    }
    
    public String getName() {
        if (user == null) {
            return null;
        }
        return user.getLogin();
    }
    
    public String logOut() {
        Logger.getLogger(UserInformationBean.class).info("from logOUt");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "welcome?faces-redirect=true";
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }



    public boolean isGuest() {
        return guest;
    }
    
}
