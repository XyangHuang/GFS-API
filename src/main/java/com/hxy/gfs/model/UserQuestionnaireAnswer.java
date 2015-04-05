package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "user_questionnaire_answer")
@JsonRootName("user_questionnaire_answer")
public class UserQuestionnaireAnswer extends BaseModel implements Serializable
{
    private static final long serialVersionUID = 4150813755678437379L;
    
    @Column(name = "user_id", nullable = false)
    @JsonProperty("user_id")
    private long userId;
    
    @Column(name = "questionnaire_id", nullable = false)
    @JsonProperty("questionnaire_id")
    private long questionnaireId;
    
    @Column(name = "question_id", nullable = false)
    @JsonProperty("question_id")
    private long questionId;

    @Column(name = "choice_id", nullable = false)
    @JsonProperty("choice_id")
    private long choiceId; // 用户选的选项的sid
    
    @Column(name = "user_added_info")
    @JsonProperty("user_added_info")
    private String userAddedInfo; // 用户填写的信息
    
    public long getUserSid()
    {
        return userId;
    }

    public void setUserSid(long userSid)
    {
        this.userId = userSid;
    }

    public long getChoiceSid()
    {
        return choiceId;
    }

    public void setChoiceSid(long mChoiceSid)
    {
        this.choiceId = mChoiceSid;
    }

    public String getUserAddedInfo()
    {
        return userAddedInfo;
    }

    public void setUserAddedInfo(String mUserAddedInfo)
    {
        this.userAddedInfo = mUserAddedInfo;
    }

    public long getQuestionnaireSid()
    {
        return questionnaireId;
    }

    public void setQuestionnaireSid(long mQuestionnaireSid)
    {
        this.questionnaireId = mQuestionnaireSid;
    }

    public long getQuestionSid()
    {
        return questionId;
    }

    public void setQuestionSid(long mQuestionSid)
    {
        this.questionId = mQuestionSid;
    }
}
