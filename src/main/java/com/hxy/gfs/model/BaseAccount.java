package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hxy.gfs.constants.Constants;
import com.hxy.gfs.model.container.Account;

/**
 * 基础账户表
 * @author Administrator
 *
 */
@Entity
@Table(name = "base_account")
public class BaseAccount extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -200566320144937780L;

    @Column(name = Constants.FIELD_BASE_ACCOUNT_USERNAME, unique = true, columnDefinition = "VARCHAR(45)")
    private String userName;
    
    @Column(name = Constants.FIELD_BASE_ACCOUNT_PASSWORD, nullable = false, columnDefinition = "VARCHAR(45)")
    private String password;
    
    @Column(name = Constants.FIELD_BASE_ACCOUNT_NICK_NAME, columnDefinition = "VARCHAR(45)")
    private String name;
    
    @Column(name = "phone_number", columnDefinition = "VARCHAR(45)")
    private String phoneNumber;

    public String getUserName()
    {
        //
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public void copyFromAccount(Account account)
    {
        if (account != null)
        {
            this.userName = account.getUserName();
            this.password = account.getPassword();
            this.name = account.getName();
            this.phoneNumber = account.getPhoneNumber();
        }
    }
}
