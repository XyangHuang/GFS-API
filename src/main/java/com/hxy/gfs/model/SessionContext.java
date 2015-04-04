package com.hxy.gfs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.model.container.Account;

@Entity
@Table(name = "session_context")
@JsonRootName("sessioncontext")
public class SessionContext implements Serializable {

    private static final long serialVersionUID = 6827625899927899731L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "token", columnDefinition = "VARCHAR(36)")
    @JsonProperty("token")
    private String token;
    
    @Column(name = "login_time")
    @JsonProperty("logintime")
    private Date loginTime;
    
    @Column(name = "expire_time")
    @JsonIgnore
    private Date expireTime;
    
    @Column(name = "user_id")
    @JsonProperty("userId")
    private long userId;
    
    @Transient
    @JsonProperty("userName")
    private String userName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", insertable = false, updatable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    private Date createdTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_time", insertable = false, updatable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @JsonIgnore
    private Date lastUpdatedTime;
    
    @Column(name = "role", nullable = false)
    @JsonIgnore
    private int role;

    @Transient
    @JsonIgnore
    private Account account;

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
