package com.hxy.gfs.resource;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.hxy.gfs.exception.LoginException;
import com.hxy.gfs.exception.ServiceErrorException;
import com.hxy.gfs.i18n.MessageKeys;
import com.hxy.gfs.model.SessionContext;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.model.container.LoginForm;
import com.hxy.gfs.service.SessionContextService;
import com.hxy.gfs.service.UserService;
import com.hxy.gfs.utils.JsonUtil;
import com.hxy.gfs.utils.MD5Util;

@Component
@Path("login")
public class LoginResource
{

    @Resource
    private UserService userService;

    @Resource
    private SessionContextService sessionContextService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userLogin(String inString)
    {
        LoginForm loginForm = JsonUtil.getPojoFromJsonString(inString, LoginForm.class);

        Account student = null;

        try
        {
            student = userService.getByUserName(loginForm.getUserName());
        } catch (Exception e)
        {
            throw new ServiceErrorException("User name or password is wrong.", MessageKeys.INTERNAL_SERVER_ERROR);
        }

        if (student != null && student.getPassword().equals(MD5Util.getMd5(loginForm.getPassword())))
        {
            SessionContext sessionContext = sessionContextService.create(student);
            return JsonUtil.getJsonStringFromPojo(sessionContext);
        } else
        {
            throw new LoginException("User name or password is wrong.", MessageKeys.USER_NAME_OR_PASSWORD_IS_WRONG);
        }
    }
}
