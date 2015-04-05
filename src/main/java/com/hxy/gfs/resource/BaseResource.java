package com.hxy.gfs.resource;

import java.util.Date;

import javax.annotation.Resource;

import com.hxy.gfs.enums.UserRole;
import com.hxy.gfs.exception.UnAuthorizedException;
import com.hxy.gfs.i18n.MessageKeys;
import com.hxy.gfs.model.SessionContext;
import com.hxy.gfs.service.SessionContextService;

public class BaseResource
{
    @Resource
    private SessionContextService sessionContextService;

    /**
     * Get sessionContext by token
     * 
     * @param token
     *            The id of sessionContext
     * @param allowedRoles
     *            Roles which are allowed to access
     * @return If the user has the exact role and its session is not expired,
     *         return sessionContext, or throw exception
     */
    protected boolean filterSessionContext(String token, int allowedRole)
    {
        SessionContext sessionContext = sessionContextService.getByToken(token);
        if (sessionContext != null)
        {
            if (!isSessionContextExpired(sessionContext))
            {
                if (sessionContext.getRole() >= allowedRole)
                {
                    flushSessionContext(token);
                    return true;
                }
            }
        } else if (UserRole.ALL == allowedRole)
        {
            return true;
        }
        throw new UnAuthorizedException("Error 401 Unauthorized",
                MessageKeys.UNAUTHORIZED);
    }

    protected void flushSessionContext(String token)
    {
        SessionContext sessionContext = sessionContextService.getByToken(token);
        sessionContextService.flushSessionContext(sessionContext);
    }

    private boolean isSessionContextExpired(SessionContext sessionContext)
    {
        Date date = new Date();
        if (date.getTime() < sessionContext.getExpireTime().getTime())
        {
            return false;
        } else
        {
            sessionContextService.delete(sessionContext.getToken());
            return true;
        }
    }
}
