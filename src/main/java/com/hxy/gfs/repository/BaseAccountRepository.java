package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.BaseAccount;

public interface BaseAccountRepository extends CrudRepository<BaseAccount, Long> {
    
    @Query("FROM BaseAccount u WHERE u.userName=:userName AND u.markForDelete=0")
    public BaseAccount getBaseAccountByUserName(@Param("userName") String userName);

    @Modifying
    @Query("UPDATE BaseAccount u SET u.password=:newPassword WHERE u.id=:userId")
    public int changePassword(@Param("userId") long userId, @Param("newPassword") String newPassword);

    @Modifying
    @Query("UPDATE BaseAccount u SET u.markForDelete=0 WHERE u.id=:userId")
    public int deleteByIdLogically(@Param("userId") long userId);
}