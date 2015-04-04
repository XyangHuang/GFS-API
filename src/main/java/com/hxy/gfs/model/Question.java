package com.hxy.gfs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.constants.Constants;

@Entity
@Table(name = Constants.TABLE_QUESTION_MODEL)
@JsonRootName(Constants.TABLE_QUESTION_MODEL)
public class Question extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -7789025606924508331L;

    @Column(name = Constants.TABLE_QUESTION_MODEL_QUESTIONNAIRE_ID, nullable = false)
    @JsonProperty(Constants.TABLE_QUESTION_MODEL_QUESTIONNAIRE_ID)
    private long questionnaireId;

    @Column(name = Constants.TABLE_QUESTION_MODEL_TITLE, nullable = false)
    @JsonProperty(Constants.TABLE_QUESTION_MODEL_TITLE)
    private String title;

    @Column(name = Constants.TABLE_QUESTION_MODEL_QUESTION_TYPE, nullable = false)
    @JsonProperty(Constants.TABLE_QUESTION_MODEL_QUESTION_TYPE)
    private byte questionType;

    @Column(name = Constants.TABLE_QUESTION_MODEL_QUESTION_NUMBER, nullable = false)
    @JsonProperty(Constants.TABLE_QUESTION_MODEL_QUESTION_NUMBER)
    private int questionNumber;
    
    @Transient
    @JsonProperty("choices")
    private List<QuestionChoice> choices;
    
    public long getQuestionnaireId()
    {
        return questionnaireId;
    }

    public void setQuestionnaireId(long questionnaireId)
    {
        this.questionnaireId = questionnaireId;
    }

    public List<QuestionChoice> getChoices()
    {
        return choices;
    }

    public void setChoices(List<QuestionChoice> choices)
    {
        this.choices = choices;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public byte getQuestionType()
    {
        return questionType;
    }

    public void setQuestionType(byte questionType)
    {
        this.questionType = questionType;
    }

    public int getQuestionNumber()
    {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber)
    {
        this.questionNumber = questionNumber;
    }
    
    public void addChoice(QuestionChoice choice)
    {
        if (choice == null) return;
        
        if (choices == null)
        {
            choices = new ArrayList<QuestionChoice>();
        }
        
        choices.add(choice);
    }
}
