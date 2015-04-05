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
@Table(name = "student")
@JsonRootName("student")
@QueryField({ Constants.FIELD_BASE_ACCOUNT_USERNAME, Constants.FIELD_BASE_ACCOUNT_PASSWORD })
public class Student extends Account implements Serializable {

    private static final long serialVersionUID = -2133244809845845692L;
    
    @Column(name = "profession_id")
    @JsonProperty("profession_id")
    private long professionId;
    
    @Column(name = "employ_id")
    @JsonProperty("employ_id")
    private long employerId;
    
    public long getProfessionId()
    {
        return professionId;
    }

    public void setProfessionId(long professionId)
    {
        this.professionId = professionId;
    }

    public long getEmployerId()
    {
        return employerId;
    }

    public void setEmployerId(long employerId)
    {
        this.employerId = employerId;
    }
}
