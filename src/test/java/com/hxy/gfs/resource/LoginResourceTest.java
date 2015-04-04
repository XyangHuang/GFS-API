package com.hxy.gfs.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.hxy.gfs.model.SessionContext;
import com.hxy.gfs.model.container.LoginForm;
import com.hxy.gfs.utils.JsonUtil;

public class LoginResourceTest extends TestBase 
{
    private static final String BASE_PATH = "login/";
    
    @Test
    public void testUserLogin() {
        LoginForm loginForm = new LoginForm();
        loginForm.setUserName("my user");
        loginForm.setPassword("123456");
        
        Response response = doPost(BASE_PATH + "user", userToken, JsonUtil.getJsonStringFromPojo(loginForm));
        assertEquals("Create user fail", Status.OK.getStatusCode(), response.getStatus());
        String returnJson = response.readEntity(String.class);
        SessionContext sessionContext = JsonUtil.getPojoFromJsonString(returnJson, SessionContext.class);
        assertNotNull("Create user fail", sessionContext);
    }
}
