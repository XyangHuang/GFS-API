package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEvaluation extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -8387063581771527023L;
    
    /**
     * 用户的base_account_id
     */
    @Column(name = "base_account_id")
    @JsonProperty("base_account_id")
    private long baseAccountId;
    
    /**
     * 评价的对象
     */
    @Column(name = "evaluation_object")
    @JsonProperty("evaluation_object")
    private int evaluationObject;

    @Column(name = "criterion_id")
    @JsonProperty("criterion_id")
    private long criterionId;

    @Column(name = "score")
    @JsonProperty("score")
    private double score;

    public long getBaseAccountId()
    {
        return baseAccountId;
    }

    public void setBaseAccountId(long baseAccountId)
    {
        this.baseAccountId = baseAccountId;
    }

    public int getEvaluationObject()
    {
        return evaluationObject;
    }

    public void setEvaluationObject(int evaluationObject)
    {
        this.evaluationObject = evaluationObject;
    }

    public long getCriterionId()
    {
        return criterionId;
    }

    public void setCriterionId(long criterionId)
    {
        this.criterionId = criterionId;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }
}
