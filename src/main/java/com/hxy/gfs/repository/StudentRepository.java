package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    
    @Query("FROM Student u WHERE u.baseAccountId=:baseAccountId AND u.markForDelete=0")
    public Student getStudentByUserName(@Param("baseAccountId") long baseAccountId);
}