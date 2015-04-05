package com.hxy.gfs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.QuestionChoice;
import com.hxy.gfs.model.Question;
import com.hxy.gfs.model.Questionnaire;
import com.hxy.gfs.repository.QuestionChoiceRepository;
import com.hxy.gfs.repository.QuestionRepository;
import com.hxy.gfs.repository.QuestionnaireRepository;
import com.hxy.gfs.service.QuestionnaireService;

@Service("questionnaireService")
public class QuestionnaireServiceImpl implements QuestionnaireService
{
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private QuestionChoiceRepository choiceRepository;

    @Override
    @Transactional
    public void updateQuestionnaire(Questionnaire questionnaire)
    {
        if (questionnaire != null)
        {
            questionnaireRepository.save(questionnaire);
        }
    }

    @Override
    @Transactional
    public void createEntireQuestionnaire(Questionnaire entireQuestionnaire)
    {
        if (entireQuestionnaire != null)
        {
            if (entireQuestionnaire.getQuestions() == null) return;

            questionnaireRepository.save(entireQuestionnaire);
            
            if (entireQuestionnaire.getId() == 0) return;
            
            for (Question question : entireQuestionnaire.getQuestions())
            {
                question.setQuestionnaireId(entireQuestionnaire.getId());
                questionRepository.save(question);
                
                if (question.getId() == 0 || question.getChoices() == null) continue;
                
                for (QuestionChoice choice : question.getChoices())
                {
                    choice.setQuestionId(question.getId());
                    choiceRepository.save(choice);
                }
            }
        }
    }

    @Override
    @Transactional
    public void deleteEntireQuestionnaire(long questionnaireId)
    {
        Questionnaire questionnaire = questionnaireRepository.findOne(questionnaireId);
        
        if (questionnaire == null) return;
        
        questionnaireRepository.delete(questionnaireId);
        
        List<Long> questionIds = questionRepository.getQuestionIdsByQuestionnaireId(questionnaireId);
        
        questionRepository.deleteQuestionsByQuestionnaireId(questionnaireId);
        
        if (questionIds != null)
        {
            for (long questionId : questionIds)
            {
                choiceRepository.deleteChoicesByQuestionId(questionId);
            }
        }
    }

    @Override
    @Transactional
    public void updateEntireQuestionnaire(Questionnaire entireQuestionnaire)
    {
        if (entireQuestionnaire != null)
        {
            // 更新问卷信息
            questionnaireRepository.save(entireQuestionnaire);
            
            if (entireQuestionnaire.getQuestions() == null) return;
            
            List<Long> questionIdsInDB = questionRepository.getQuestionIdsByQuestionnaireId(entireQuestionnaire.getId());
            
            // questionIdsInDB不可为null
            if (questionIdsInDB == null) questionIdsInDB = new ArrayList<Long>();
            
            List<Long> choiceIdsInDB = new ArrayList<Long>();
            
            for (Question question : entireQuestionnaire.getQuestions())
            {
                // 更新问题
                questionRepository.save(question);
                 
                if (questionIdsInDB.contains(question.getId()))
                {
                    questionIdsInDB.remove(question.getId());
                    // 将新的问题中原本就存在的问题的选项的id添加进来
                    choiceIdsInDB.addAll(choiceRepository.getChoiceIdsByQuestionId(question.getId()));
                }
                
                if (question.getChoices() == null) continue;
                
                // 更新选项
                for (QuestionChoice choice : question.getChoices())
                {
                    choiceRepository.save(choice);
                    
                    // 去掉原本就存在的选项，剩下的就是管理员删除的
                    if (choiceIdsInDB.contains(choice.getId()))
                    {
                        choiceIdsInDB.remove(choice.getId());
                    }
                }
            }
            
            // 管理员有删掉问题
            if (!questionIdsInDB.isEmpty())
            {
                // 逻辑删除该问题和他的选项
                for (long questionId : questionIdsInDB)
                {
                    questionRepository.deleteQuestionByIdLogically(questionId);
                    choiceRepository.deleteChoicesByQuestionIdLogically(questionId);
                }
            }

            // 管理员有删除选项
            if (! choiceIdsInDB.isEmpty())
            {
                for (long choiceId : choiceIdsInDB)
                {
                    choiceRepository.deleteChoiceByIdLogically(choiceId);
                }
            }
        }
    }

    @Override
    @Transactional
    public Questionnaire getEntireQuestionnaireById(long questionnaireId)
    {
        Questionnaire entireQuestionnaire = questionnaireRepository.findOne(questionnaireId);
        
        if (entireQuestionnaire == null) return null;
        
        List<Question> questions = questionRepository.getQuestionsByQuestionnaireId(questionnaireId);
        
        if (questions != null)
        {
            for (Question question : questions)
            {
                question.setChoices(choiceRepository.getChoicesByQuestionId(question.getId()));
            }
        }
        
        entireQuestionnaire.setQuestions(questions);
        
        return entireQuestionnaire;
    }

    @Override
    @Transactional
    public List<Questionnaire> getQuestionnaires()
    {
        return questionnaireRepository.getQuestionnaires();
    }

    @Override
    @Transactional
    public void deleteEntireQuestionnaireLogically(long questionnaireId)
    {
        Questionnaire questionnaire = questionnaireRepository.findOne(questionnaireId);
        
        if (questionnaire == null) return;
        
        questionnaire.setMarkForDelete(true);
        questionnaireRepository.save(questionnaire);
        
        List<Long> questionIds = questionRepository.getQuestionIdsByQuestionnaireId(questionnaireId);
        
        questionRepository.deleteQuestionsByQuestionnaireIdLogically(questionnaireId);
        
        if (questionIds != null)
        {
            for (long questionId : questionIds)
            {
                choiceRepository.deleteChoicesByQuestionIdLogically(questionId);
            }
        }
    }

    @Override
    @Transactional
    public Questionnaire getQuestionnairById(long questionnaireId)
    {
        return questionnaireRepository.findOne(questionnaireId);
    }

    @Override
    public void createQuestionnaire(Questionnaire questionnaire)
    {
        if (questionnaire != null)
        {
            questionnaireRepository.save(questionnaire);
        }
    }
}
