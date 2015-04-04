package com.hxy.gfs.service;

import com.hxy.gfs.model.SessionContext;

public interface SessionContextService {

    public SessionContext create(long userId);

    public SessionContext update(SessionContext sessionContext);

    public SessionContext getByToken(String token);

    public SessionContext flushSessionContext(SessionContext sessionContext);

    public boolean delete(String token);
}
