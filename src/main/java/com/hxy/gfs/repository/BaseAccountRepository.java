package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.BaseAccount;

public interface BaseAccountRepository extends CrudRepository<BaseAccount, Long> {
    
    @Query("FROM BaseAccount u WHERE u.userName=:userName AND u.markForDelete=0")
    public BaseAccount getUserByUserName(@Param("userName") String userName);

    @Transactional
    @Modifying
    @Query("UPDATE BaseAccount u SET u.password=:password WHERE u.id=:userId")
    public int updatePassword(@Param("userId") long userId, @Param("password") String password);
}