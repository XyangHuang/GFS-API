package com.hxy.gfs.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.repository.QuestionChoiceRepository;

public class ChoiceRepositoryTest extends TestBase
{

    @Autowired
    private QuestionChoiceRepository choiceRepository;
    
    @Test
    public void testDeleteChoiceByIdLogically()
    {
        choiceRepository.deleteChoiceByIdLogically(1);
    }
    
    @Test
    public void testGetChoiceIdsByQuestionId()
    {
        List<Long> ids = choiceRepository.getChoiceIdsByQuestionId(1);
        
        System.out.println(ids);
    }
    
    @Test
    public void testDeleteChoicesByQuestionIdLogically()
    {
        choiceRepository.deleteChoicesByQuestionIdLogically(1);
    }
}
