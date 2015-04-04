package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 作为基础部门表
 * @author Administrator
 *
 */
@Entity
@Table(name = "base_department")
public class BaseDepartment extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -1889927319725667358L;

    @Column(name = "name")
    private long name;
    
    @Column(name = "description")
    private long description;

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
}
