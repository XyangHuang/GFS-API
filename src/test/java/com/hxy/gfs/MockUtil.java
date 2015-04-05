package com.hxy.gfs;

import java.util.Random;

import com.hxy.gfs.enums.QuestionType;
import com.hxy.gfs.enums.QuestionnaireStatus;
import com.hxy.gfs.model.Question;
import com.hxy.gfs.model.QuestionChoice;
import com.hxy.gfs.model.Questionnaire;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.utils.MD5Util;

public class MockUtil
{
    public static final String MOCK_PASSWORD = MD5Util.getMd5("123456");
    public static final String MOCK_USER_NAME = "mock_user_name";
    public static final String MOCK_NAME = "mock_name";
    
    public static Questionnaire mockQuestionnaire()
    {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle("question" + new Random().nextDouble());
        questionnaire.setDescription("question" + new Random().nextDouble());
        questionnaire.setStatus(QuestionnaireStatus.UNASSIGNED.value());
        return questionnaire;
    }
    
    public static Account mockUser()
    {
        Account user = new Account();
        user.setUserName(MOCK_USER_NAME + new Random().nextDouble());
        user.setPassword(MOCK_PASSWORD);
        user.setName(MOCK_NAME);
        user.setPhoneNumber("1234567890");
        
        return user;
    }
    
    public static Questionnaire mockEntireQuestionnaire()
    {
        Random random = new Random();
        
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle("question" + random.nextDouble());
        questionnaire.setDescription("question" + random.nextDouble());
        questionnaire.setStatus(QuestionnaireStatus.UNASSIGNED.value());
        
        for (int i = 0; i < 4; i++)
        {
            Question question = new Question();
            question.setTitle("question" + random.nextDouble());
            question.setQuestionNumber(1);
            question.setQuestionType(QuestionType.ONE_CHOICE.value());
            
            for (int j = 0; j < 4; j++)
            {
                QuestionChoice choice = new QuestionChoice();
                choice.setChoiceName("choice" + random.nextDouble());
                
                if (j % 2 == 0)
                {
                    choice.setNeedAddInfo(true);
                }
                else
                {
                    choice.setNeedAddInfo(false);
                }
                
                question.addChoice(choice);
            }
            
            questionnaire.addQuestion(question);
        }
        
        return questionnaire;
    }
}
