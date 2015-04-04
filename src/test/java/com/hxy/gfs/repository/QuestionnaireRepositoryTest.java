package com.hxy.gfs.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.model.Questionnaire;
import com.hxy.gfs.repository.QuestionnaireRepository;

public class QuestionnaireRepositoryTest extends TestBase
{
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    
    private Questionnaire questionnaire;
    
    @Before
    public void setUp()
    {
        questionnaire = MockUtil.mockQuestionnaire();
    }

    @After
    public void tearDown()
    {
        Questionnaire questionnaireInDB = questionnaireRepository.findOne(questionnaire.getId());
        
        if (questionnaireInDB != null)
        {
            questionnaireRepository.delete(questionnaire.getId());
        }
    }
    
    @Test
    public void testCreateQuestionnarieAndGetQuestionnarieById()
    {
        questionnaireRepository.save(questionnaire);
        
        Questionnaire questionnaireInDB = questionnaireRepository.findOne(questionnaire.getId());
        
        assertNotNull(questionnaireInDB);
        
        assertEquals(questionnaire.getTitle(), questionnaireInDB.getTitle());
        assertEquals(questionnaire.getDescription(), questionnaireInDB.getDescription());
        assertEquals(questionnaire.getStatus(), questionnaireInDB.getStatus());
    }
    
    @Test
    public void testUpdateQuestionnarie()
    {
        questionnaireRepository.save(questionnaire);
        
        Questionnaire questionnaireInDB = questionnaireRepository.findOne(questionnaire.getId());
        
        assertNotNull(questionnaireInDB);
        
        questionnaire.setTitle("title");
        
        questionnaireRepository.save(questionnaire);
        
        questionnaireInDB = questionnaireRepository.findOne(questionnaire.getId());

        assertNotNull(questionnaireInDB);
        
        assertEquals(questionnaire.getTitle(), questionnaireInDB.getTitle());
    }
}
