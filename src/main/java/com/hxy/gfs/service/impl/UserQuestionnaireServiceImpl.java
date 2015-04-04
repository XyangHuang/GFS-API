package com.hxy.gfs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxy.gfs.model.UserQuestionnaire;
import com.hxy.gfs.repository.UserQuestionnaireRepository;
import com.hxy.gfs.service.UserQuestionnaireService;

@Service("userQuestionnaireService")
public class UserQuestionnaireServiceImpl implements UserQuestionnaireService
{
    @Autowired
    private UserQuestionnaireRepository userQuestionnaireRepository;
    
    @Override
    public UserQuestionnaire create(UserQuestionnaire userQuestionnaire)
    {
        return userQuestionnaireRepository.save(userQuestionnaire);
    }

    @Override
    public UserQuestionnaire update(UserQuestionnaire userQuestionnaire)
    {
        return userQuestionnaireRepository.save(userQuestionnaire);
    }

    @Override
    public UserQuestionnaire getById(long id)
    {
        return userQuestionnaireRepository.findOne(id);
    }

    @Override
    public void deleteById(long id)
    {
        userQuestionnaireRepository.delete(id);
    }

    @Override
    public void deleteByIdLogically(long id)
    {
        UserQuestionnaire userQuestionnaire = userQuestionnaireRepository.findOne(id);
        
        if (userQuestionnaire != null)
        {
            userQuestionnaire.setMarkForDelete(true);
            userQuestionnaireRepository.save(userQuestionnaire);
        }

    }

}
