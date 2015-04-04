package com.hxy.gfs.model.container;

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
}
