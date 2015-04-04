package com.hxy.gfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.QuestionChoice;

public interface QuestionnaireChoiceRepository extends CrudRepository<QuestionChoice, Long> 
{
    @Query("FROM Choice c WHERE c.questionId=:questionId AND c.markForDelete=0")
    public List<QuestionChoice> getChoicesByQuestionId(@Param("questionId") long questionId);
    
    @Query("SELECT c.id FROM Choice c WHERE c.questionId=?1 AND c.markForDelete=0")
    public List<Long> getChoiceIdsByQuestionId(long questionId);
    
    @Modifying
    @Transactional
    @Query("UPDATE Choice c SET c.markForDelete=1 WHERE c.id=?1 AND c.markForDelete=0")
    public int deleteChoiceByIdLogically(long choiceId);

    @Modifying
    @Transactional
    @Query("UPDATE Choice c SET c.markForDelete=1 WHERE c.questionId=?1 AND c.markForDelete=0")
    public int deleteChoicesByQuestionIdLogically(long questionId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Choice c WHERE c.questionId=?1")
    public int deleteChoicesByQuestionId(long questionId);
}
