package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 评价标准表
 * @author Administrator
 *
 */
@Entity
@Table(name = "evaluation_criterion")
@JsonRootName("evaluation_criterion")
public class EvaluationCriterion extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -7881814307762997068L;
    
    @Column(name = "evaluation_object")
    @JsonProperty("evaluation_object")
    private int evaluationObject;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "level")
    @JsonProperty("level")
    private int level;

    @Column(name = "parent_id")
    @JsonProperty("parent_id")
    private long parentId;

    public int getEvaluationObject()
    {
        return evaluationObject;
    }

    public void setEvaluationObject(int evaluationObject)
    {
        this.evaluationObject = evaluationObject;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public long getParentId()
    {
        return parentId;
    }

    public void setParentId(long parentId)
    {
        this.parentId = parentId;
    }
}
