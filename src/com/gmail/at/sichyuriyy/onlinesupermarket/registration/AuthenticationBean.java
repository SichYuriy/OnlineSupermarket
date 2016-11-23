package com.gmail.at.sichyuriyy.onlinesupermarket.registration;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

@ManagedBean(name="authentication")
@ApplicationScoped
public class AuthenticationBean {
    
    private String login;
    
    public String logSuccess() {
        String userName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        Logger.getLogger(AuthenticationBean.class).info("login success " + userName);
        return "";
    }
    
    public String logFail() {
        Logger.getLogger(AuthenticationBean.class).info("login failed " + login);
        return "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
