package com.hxy.gfs.service;

import com.hxy.gfs.model.UserQuestionnaire;

public interface UserQuestionnaireService
{
    public UserQuestionnaire create(UserQuestionnaire userQuestionnaire);

    public UserQuestionnaire update(UserQuestionnaire userQuestionnaire);

    public UserQuestionnaire getById(long id);

    public void deleteById(long id);
    
    public void deleteByIdLogically(long id);
}
