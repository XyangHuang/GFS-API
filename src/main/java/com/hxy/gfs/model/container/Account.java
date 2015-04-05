package com.hxy.gfs.model.container;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hxy.gfs.constants.Constants;
import com.hxy.gfs.model.BaseAccount;
import com.hxy.gfs.model.BaseModel;

/**
 * 用来作为父类的
 * @author Administrator
 *
 */
@MappedSuperclass
public class Account extends BaseModel
{
    @Column(name = "base_account_id")
    @JsonProperty("base_account_id")
    private long baseAccountId;
    
    @Transient
    @JsonProperty("userName")
    private String userName;

    @Transient
    @JsonProperty(Constants.FIELD_BASE_ACCOUNT_PASSWORD)
    private String password;

    @Transient
    @JsonProperty(Constants.FIELD_BASE_ACCOUNT_NICK_NAME)
    private String name;

    @Transient
    @JsonProperty("phone_number")
    private String phoneNumber;
    
    @Transient
    @JsonProperty("role")
    private int role;

    public long getBaseAccountId()
    {
        return baseAccountId;
    }

    public void setBaseAccountId(long baseAccountId)
    {
        this.baseAccountId = baseAccountId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }
    
    public void copyFromBaseAccount(BaseAccount baseAccount)
    {
        if (baseAccount != null)
        {
            this.userName = baseAccount.getUserName();
            this.name = baseAccount.getName();
            this.phoneNumber = baseAccount.getPhoneNumber();
            this.role = baseAccount.getRole();
        }
    }
}
