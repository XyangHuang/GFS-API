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
@Table(name = "employer_admin")
@JsonRootName("employer_admin")
@QueryField({ Constants.FIELD_BASE_ACCOUNT_USERNAME, Constants.FIELD_BASE_ACCOUNT_PASSWORD })
public class EmployerAdmin extends Account implements Serializable {

    private static final long serialVersionUID = -3058226900609265985L;
    
    @Column(name = "employer_id")
    @JsonProperty("employer_id")
    private long employerId;

    public long getEmployerId()
    {
        return employerId;
    }

    public void setEmployerId(long employerId)
    {
        this.employerId = employerId;
    }
}
