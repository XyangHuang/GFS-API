package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.Profession;

public interface ProfessionRepository extends CrudRepository<Profession, Long> {

    @Query("FROM Profession u WHERE u.baseDepartmentId=:baseDepartmentId AND u.markForDelete=0")
    public Profession getProfessionByBaseDepartmentId(@Param("baseDepartmentId") long baseDepartmentId);
}