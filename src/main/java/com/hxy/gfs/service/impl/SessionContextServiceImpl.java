package com.hxy.gfs.service.impl;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.SessionContext;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.repository.SessionContextRepository;
import com.hxy.gfs.service.SessionContextService;

@Service
public class SessionContextServiceImpl implements SessionContextService {

    @Resource
    private SessionContextRepository sessionContextRepository;

    @Override
    @Transactional
    public SessionContext create(Account user) {
        if (user == null) return null;
        
        SessionContext sessionContext = new SessionContext();
        sessionContext.setUserId(user.getBaseAccountId());
        sessionContext.setRole(user.getRole());
        sessionContext.setUserName(user.getUserName());
        // Set login time
        Date loginTime = new Date();
        sessionContext.setLoginTime(loginTime);
        // Set expire time by default 30 minutes
        Calendar cal = Calendar.getInstance();
        cal.setTime(loginTime);
        cal.add(Calendar.MINUTE, 30);
        Date expireTime = cal.getTime();
        sessionContext.setExpireTime(expireTime);
        return sessionContextRepository.save(sessionContext);
    }

    @Override
    @Transactional
    public SessionContext update(SessionContext sessionContext) {
        if (sessionContext.getToken() != null) {
            return sessionContextRepository.save(sessionContext);
        } else {
            return null;
        }
    }

    @Override
    public SessionContext getByToken(String token) {
        return sessionContextRepository.getByToken(token);
    }

    @Override
    @Transactional
    public SessionContext flushSessionContext(SessionContext sessionContext) {
        if (sessionContext != null) {
            // Set expire time to be 30 minutes later
            Date currentTime = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentTime);
            cal.add(Calendar.MINUTE, 30);
            Date expireTime = cal.getTime();
            sessionContext.setExpireTime(expireTime);
            return update(sessionContext);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean delete(String token) {
        sessionContextRepository.delete(token);
        SessionContext sessionContext = sessionContextRepository.getByToken(token);
        if (sessionContext == null) {
            return true;
        } else {
            return false;
        }
    }

}
