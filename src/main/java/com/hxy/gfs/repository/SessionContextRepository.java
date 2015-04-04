package com.hxy.gfs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hxy.gfs.model.SessionContext;

public interface SessionContextRepository extends CrudRepository<SessionContext, String> {

    @Query("FROM SessionContext s WHERE s.token=:token")
    public SessionContext getByToken(@Param("token") String token);
}
