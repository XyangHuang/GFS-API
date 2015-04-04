package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.BaseAccount;
import com.hxy.gfs.model.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Long> {
    
    @Query("FROM Employer u WHERE u.baseDepartmentId=:baseDepartmentId AND u.markForDelete=0")
    public BaseAccount getUserByUserName(@Param("baseDepartmentId") long baseDepartmentId);
}