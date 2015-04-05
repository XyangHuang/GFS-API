package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.EmployerAdmin;

public interface EmployerAdminRepository extends CrudRepository<EmployerAdmin, Long> {
    
    @Query("FROM EmployerAdmin u WHERE u.baseAccountId=:baseAccountId AND u.markForDelete=0")
    public EmployerAdmin getEmployerAdminByBaseAccountId(@Param("baseAccountId") long baseAccountId);

    @Modifying
    @Query("DELETE FROM EmployerAdmin u WHERE u.baseAccountId=:baseAccountId")
    public void deleteByBaseAccountId(@Param("baseAccountId") long baseAccountId);

    @Modifying
    @Query("UPDATE EmployerAdmin u SET u.markForDelete = 0 WHERE u.baseAccountId=:baseAccountId")
    public void deleteByBaseAccountIdLogically(@Param("baseAccountId") long baseAccountId);
}