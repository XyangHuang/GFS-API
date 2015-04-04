package com.hxy.gfs.model.container;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("login")
public class LoginForm implements Serializable {

    private static final long serialVersionUID = -2932007347462635985L;

    @JsonProperty("userName")
    private String userName;
    
    @JsonProperty("password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String mUsername) {
        this.userName = mUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
