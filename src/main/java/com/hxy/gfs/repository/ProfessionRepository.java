package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.Profession;

public interface ProfessionRepository extends CrudRepository<Profession, Long> {

    @Query("FROM Profession u WHERE u.baseDepartmentId=:baseDepartmentId AND u.markForDelete=0")
    public Profession getProfessionByBaseDepartmentId(@Param("baseDepartmentId") long baseDepartmentId);

    @Modifying
    @Query("DELETE FROM Profession u WHERE u.baseDepartmentId=:baseDepartmentId")
    public void deleteByBaseDepartmentId(@Param("baseDepartmentId") long baseDepartmentId);

    @Modifying
    @Query("UPDATE Profession u SET u.markForDelete = 0 WHERE u.baseDepartmentId=:baseDepartmentId")
    public void deleteByBaseDepartmentIdLogically(@Param("baseDepartmentId") long baseDepartmentId);
}