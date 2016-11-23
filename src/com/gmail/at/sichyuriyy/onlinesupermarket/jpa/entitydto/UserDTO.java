package com.gmail.at.sichyuriyy.onlinesupermarket.jpa.entitydto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="userDTO")
@RequestScoped
public class UserDTO {
    
    private String login;
    private String passwd;
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
