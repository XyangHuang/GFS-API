package com.hxy.gfs.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.model.Questionnaire;
import com.hxy.gfs.service.QuestionnaireService;

public class QuestionnaireServiceTest extends TestBase
{
    @Autowired
    private QuestionnaireService questionnaireService;
    
    private Questionnaire questionnarie;
    
    @Before
    public void setUp()
    {
        questionnarie = MockUtil.mockEntireQuestionnaire();
    }

    @After
    public void tearDown()
    {
        questionnaireService.deleteEntireQuestionnaire(questionnarie.getId());
    }
    
    @Test
    public void testCreateEntireQuestionnaire()
    {
        Questionnaire entireQuestionnaire = MockUtil.mockEntireQuestionnaire();
        
        questionnaireService.createEntireQuestionnaire(entireQuestionnaire);
    }
    
    @Test
    public void testCreateQuestionnaire()
    {
        Questionnaire questionnaire = MockUtil.mockQuestionnaire();
        
        questionnaireService.createQuestionnaire(questionnaire);
    }

    @Test
    public void testUpdateEntireQuestionnaire()
    {
        
    }

    @Test
    public void testDeleteEntireQuestionnaire()
    {
        questionnaireService.deleteEntireQuestionnaire(1);
    }
}
