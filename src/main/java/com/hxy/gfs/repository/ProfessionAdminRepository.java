package com.hxy.gfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.BaseAccount;
import com.hxy.gfs.model.Student;

public interface ProfessionAdminRepository extends CrudRepository<BaseAccount, Long> {
    
    @Query("FROM BaseAccount u WHERE u.userName=:userName AND u.markForDelete=0")
    public BaseAccount getUserByUserName(@Param("userName") String userName);

    @Transactional
    @Modifying
    @Query("UPDATE BaseAccount u SET u.password=:password WHERE u.id=:userId")
    public int updatePassword(@Param("userId") long userId, @Param("password") String password);

    @Transactional
    @Query("FROM User u WHERE u.markForDelete=0")
    public List<Student> getUsers();
}