package com.hxy.gfs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.constants.Constants;

@Entity
@Table(name = Constants.TABLE_USER_QUESTIONNAIRE_MODEL)
@JsonRootName(Constants.TABLE_USER_QUESTIONNAIRE_MODEL)
public class UserQuestionnaire extends BaseModel implements Serializable
{
    private static final long serialVersionUID = 3360072752821856967L;

    @Column(name = Constants.TABLE_USER_QUESTIONNAIRE_MODEL_USER_ID, nullable = false)
    @JsonProperty(Constants.TABLE_USER_QUESTIONNAIRE_MODEL_USER_ID)
    private long userSid;

    @Column(name = Constants.TABLE_USER_QUESTIONNAIRE_MODEL_QUESTIONNAIRE_ID, nullable = false)
    @JsonProperty(Constants.TABLE_USER_QUESTIONNAIRE_MODEL_QUESTIONNAIRE_ID)
    private long questionnaireSid;
    
    @Column(name = Constants.TABLE_USER_QUESTIONNAIRE_MODEL_SUMBIT_TIME)
    @JsonProperty(Constants.TABLE_USER_QUESTIONNAIRE_MODEL_SUMBIT_TIME)
    private Date submitTime;
    
    public long getUserSid()
    {
        return userSid;
    }

    public void setUserSid(long mUserSid)
    {
        this.userSid = mUserSid;
    }

    public long getQuestionnaireSid()
    {
        return questionnaireSid;
    }

    public void setQuestionnaireSid(long mQuestionnaireSid)
    {
        this.questionnaireSid = mQuestionnaireSid;
    }

    public Date getSubmitTime()
    {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime)
    {
        this.submitTime = submitTime;
    }
}
