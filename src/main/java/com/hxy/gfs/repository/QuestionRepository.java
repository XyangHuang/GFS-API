package com.hxy.gfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> 
{
    @Transactional
    @Query("FROM Question q WHERE q.questionnaireId=:questionnaireId AND q.markForDelete=0")
    public List<Question> getQuestionsByQuestionnaireId(@Param("questionnaireId") long questionnaireId);

    @Transactional
    @Query("SELECT id FROM Question q WHERE q.questionnaireId=?1 AND q.markForDelete=0")
    public List<Long> getQuestionIdsByQuestionnaireId(long questionnaireId);
    
    @Transactional
    @Modifying
    @Query("UPDATE Question q SET q.markForDelete=1 WHERE q.id=?1 AND q.markForDelete=0")
    public int deleteQuestionByIdLogically(long questionId);

    @Transactional
    @Modifying
    @Query("UPDATE Question q SET q.markForDelete=1 WHERE q.questionnaireId=?1 AND q.markForDelete=0")
    public int deleteQuestionsByQuestionnaireIdLogically(long questionnaireId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Question q WHERE q.questionnaireId=?1")
    public int deleteQuestionsByQuestionnaireId(long questionnaireId);
}
