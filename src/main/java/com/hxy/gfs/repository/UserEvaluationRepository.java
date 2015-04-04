package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.UserEvaluation;

public interface UserEvaluationRepository extends CrudRepository<UserEvaluation, Long>
{
    @Query("FROM UserEvaluation u WHERE u.baseAccountId=:baseAccountId AND u.markForDelete=0")
    public UserEvaluation geUserEvaluationByBaseAccountId(@Param("baseAccountId") long baseAccountId);
}