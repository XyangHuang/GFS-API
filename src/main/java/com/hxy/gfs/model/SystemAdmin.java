package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.annotations.QueryField;
import com.hxy.gfs.constants.Constants;
import com.hxy.gfs.model.container.Account;

@Entity
@Table(name = Constants.TABLE_MANAGER_MODEL)
@JsonRootName(Constants.TABLE_MANAGER_MODEL)
@QueryField({ Constants.FIELD_BASE_ACCOUNT_USERNAME, Constants.FIELD_BASE_ACCOUNT_PASSWORD })
public class SystemAdmin extends Account implements Serializable {

    private static final long serialVersionUID = -3058226900609265985L;
    
    @Column(name = "base_account_id")
    @JsonProperty("base_account_id")
    private long baseAccountId;

    public long getBaseAccountId()
    {
        return baseAccountId;
    }

    public void setBaseAccountId(long baseAccountId)
    {
        this.baseAccountId = baseAccountId;
    }
}
