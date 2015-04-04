package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.BaseAccount;
import com.hxy.gfs.model.EmployerAdmin;

public interface EmployerAdminRepository extends CrudRepository<EmployerAdmin, Long> {
    
    @Query("FROM BaseAccount u WHERE u.userName=:userName AND u.markForDelete=0")
    public BaseAccount getUserByUserName(@Param("userName") String userName);
}