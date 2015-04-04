package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.BaseDepartment;

public interface BaseDepartmentRepository extends CrudRepository<BaseDepartment, Long> {
    
    @Query("FROM BaseDepartment u WHERE u.baseAccountId=:baseAccountId AND u.markForDelete=0")
    public BaseDepartment getBaseDepartmentByBaseAccountId(@Param("baseAccountId") long baseAccountId);
}