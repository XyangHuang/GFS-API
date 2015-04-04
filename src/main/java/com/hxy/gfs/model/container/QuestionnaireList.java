package com.hxy.gfs.model.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.model.Questionnaire;

@JsonRootName("questionnaire_list")
public class QuestionnaireList implements Serializable 
{
    private static final long serialVersionUID = 2793783016677480424L;
    
    @JsonProperty("questionnaires")
    private List<Questionnaire> questionnaires;

    public List<Questionnaire> getQuestionnaires()
    {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires)
    {
        this.questionnaires = questionnaires;
    }
    
    public void addQuestionnaire(Questionnaire questionnaire)
    {
        if (questionnaires == null)
        {
            questionnaires = new ArrayList<Questionnaire>();
        }
        
        questionnaires.add(questionnaire);
    }
}
