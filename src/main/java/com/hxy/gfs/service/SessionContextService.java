package com.hxy.gfs.service;

import com.hxy.gfs.model.SessionContext;
import com.hxy.gfs.model.container.Account;

public interface SessionContextService {

    public SessionContext create(Account user);

    public SessionContext update(SessionContext sessionContext);

    public SessionContext getByToken(String token);

    public SessionContext flushSessionContext(SessionContext sessionContext);

    public boolean delete(String token);
}
