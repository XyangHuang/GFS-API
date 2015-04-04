package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.ProfessionAdmin;

public interface ProfessionAdminRepository extends CrudRepository<ProfessionAdmin, Long> {
    
    @Query("FROM ProfessionAdmin u WHERE u.baseAccountId=:baseAccountId AND u.markForDelete=0")
    public ProfessionAdmin getProfessionAdminByBaseAccountId(@Param("baseAccountId") long baseAccountId);
}