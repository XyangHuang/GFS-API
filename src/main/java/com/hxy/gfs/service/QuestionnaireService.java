package com.hxy.gfs.service;

import java.util.List;

import com.hxy.gfs.model.Questionnaire;

public interface QuestionnaireService
{
    public void updateQuestionnaire(Questionnaire questionnaire);
    
    public Questionnaire getQuestionnairById(long questionnaireId);
    
    public void createQuestionnaire(Questionnaire questionnaire);
    
    public void createEntireQuestionnaire(Questionnaire entireQuestionnaire);
    
    public void deleteEntireQuestionnaire(long questionnaireId);

    public void updateEntireQuestionnaire(Questionnaire entireQuestionnaire);
    
    public Questionnaire getEntireQuestionnaireById(long questionnaireId);
    
    /**
     * 只取问卷的信息，不取问题
     * @return
     */
    public List<Questionnaire> getQuestionnaires();
    
    public void deleteEntireQuestionnaireLogically(long questionnaireId);
}
