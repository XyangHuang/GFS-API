package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "overall_evaluation")
@JsonRootName("overall_evaluation")
public class OverallEvaluation extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -3544874614938044891L;

    /**
     * 评价的对象
     */
    @Column(name = "evaluation_object")
    @JsonProperty("evaluation_object")
    private int evaluationObject;
    
    /**
     * 哪种角色评价的
     */
    @Column(name = "evaluation_role")
    @JsonProperty("evaluation_role")
    private int evaluatRole;

    @Column(name = "overall_score")
    @JsonProperty("overall_score")
    private double overallScore;

    public int getEvaluationObject()
    {
        return evaluationObject;
    }

    public void setEvaluationObject(int evaluationObject)
    {
        this.evaluationObject = evaluationObject;
    }

    public int getEvaluatRole()
    {
        return evaluatRole;
    }

    public void setEvaluatRole(int evaluatRole)
    {
        this.evaluatRole = evaluatRole;
    }

    public double getOverallScore()
    {
        return overallScore;
    }

    public void setOverallScore(double overallScore)
    {
        this.overallScore = overallScore;
    }
}
