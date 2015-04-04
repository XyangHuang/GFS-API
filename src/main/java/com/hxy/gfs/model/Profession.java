package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.model.container.Department;

@Entity
@Table(name = "profession")
@JsonRootName("profession")
public class Profession extends Department implements Serializable
{
    private static final long serialVersionUID = -5310357347219777144L;

    @Column(name = "base_department_id")
    @JsonProperty("base_department_id")
    private long baseDepartmentId;

    public long getBaseDepartmentId()
    {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(long baseDepartmentId)
    {
        this.baseDepartmentId = baseDepartmentId;
    }
}
