package com.hxy.gfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.Questionnaire;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long>
{
    @Transactional
    @Query("FROM Questionnaire q WHERE q.markForDelete=0")
    public List<Questionnaire> getQuestionnaires();
}
