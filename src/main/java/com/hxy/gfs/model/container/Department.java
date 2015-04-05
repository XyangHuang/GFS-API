package com.hxy.gfs.model.container;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hxy.gfs.model.BaseModel;

/**
 * 作为父类
 * @author Administrator
 *
 */
@MappedSuperclass
public class Department extends BaseModel
{
    @Transient
    @JsonProperty("name")
    private long name;

    @Transient
    @JsonProperty("description")
    private long description;

    @Column(name = "base_department_id")
    @JsonProperty("base_department_id")
    private long baseDepartmentId;

    public long getName()
    {
        return name;
    }

    public void setName(long name)
    {
        this.name = name;
    }

    public long getDescription()
    {
        return description;
    }

    public void setDescription(long description)
    {
        this.description = description;
    }

    public long getBaseDepartmentId()
    {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(long baseDepartmentId)
    {
        this.baseDepartmentId = baseDepartmentId;
    }
}
