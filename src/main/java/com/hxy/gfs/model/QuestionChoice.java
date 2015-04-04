package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.constants.Constants;

@Entity
@Table(name = Constants.TABLE_CHOICE_MODEL)
@JsonRootName(Constants.TABLE_CHOICE_MODEL)
public class QuestionChoice extends BaseModel implements Serializable
{
    private static final long serialVersionUID = 2177325190737626891L;

    @Column(name = Constants.TABLE_CHOICE_MODEL_QUESTION_ID, nullable = false)
    @JsonProperty(Constants.TABLE_CHOICE_MODEL_QUESTION_ID)
    private long questionId;

    @Column(name = Constants.TABLE_CHOICE_MODEL_CHOICE_NAME, nullable = false)
    @JsonProperty(Constants.TABLE_CHOICE_MODEL_CHOICE_NAME)
    private String choiceName;

    @Column(name = Constants.TABLE_CHOICE_MODEL_NEED_ADD_INFO, nullable = false, columnDefinition = "BOOLEAN DEFAULT 0")
    @JsonProperty(Constants.TABLE_CHOICE_MODEL_NEED_ADD_INFO)
    private boolean needAddInfo;

    public long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(long questionSid)
    {
        this.questionId = questionSid;
    }

    public String getChoiceName()
    {
        return choiceName;
    }

    public void setChoiceName(String choiceName)
    {
        this.choiceName = choiceName;
    }

    public boolean isNeedAddInfo()
    {
        return needAddInfo;
    }

    public void setNeedAddInfo(boolean needAddInfo)
    {
        this.needAddInfo = needAddInfo;
    }
}
