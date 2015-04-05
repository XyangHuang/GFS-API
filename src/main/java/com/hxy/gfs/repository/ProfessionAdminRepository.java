package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.ProfessionAdmin;

public interface ProfessionAdminRepository extends CrudRepository<ProfessionAdmin, Long> {
    
    @Query("FROM ProfessionAdmin u WHERE u.baseAccountId=:baseAccountId AND u.markForDelete=0")
    public ProfessionAdmin getProfessionAdminByBaseAccountId(@Param("baseAccountId") long baseAccountId);

    @Modifying
    @Query("DELETE FROM ProfessionAdmin u WHERE u.baseAccountId=:baseAccountId")
    public void deleteByBaseAccountId(@Param("baseAccountId") long baseAccountId);

    @Modifying
    @Query("UPDATE ProfessionAdmin u SET u.markForDelete = 0 WHERE u.baseAccountId=:baseAccountId")
    public void deleteByBaseAccountIdLogically(@Param("baseAccountId") long baseAccountId);
}