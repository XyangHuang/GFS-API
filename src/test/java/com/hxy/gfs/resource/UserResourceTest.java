package com.hxy.gfs.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.hxy.gfs.model.Student;
import com.hxy.gfs.utils.JsonUtil;

public class UserResourceTest extends TestBase
{
    private static final String BASE_PATH = "user/";

    private static Student user;

    @Test
    public void testCreate() {
        String randomNumber = UUID.randomUUID().toString().replace("-", "");

        Student testUser = new Student();
        testUser.setUserName("user" + randomNumber);
        testUser.setPassword("password");
        Response response = doPost(BASE_PATH + "entity", userToken, JsonUtil.getJsonStringFromPojo(testUser));
        assertEquals("Create user fail", Status.OK.getStatusCode(), response.getStatus());
        String returnJson = response.readEntity(String.class);
        Student insertedUser = JsonUtil.getPojoFromJsonString(returnJson, Student.class);
        assertNotNull("Create user fail", insertedUser);

        user = insertedUser;
    }

    @Test
    public void testUpdatePassword() {
        user.setPassword("password2");
        Response response = doPut(BASE_PATH + "entity", userToken, JsonUtil.getJsonStringFromPojo(user));
        assertEquals("Update user password fail", Status.OK.getStatusCode(), response.getStatus());
        String returnJson = response.readEntity(String.class);
        Student updatedUser = JsonUtil.getPojoFromJsonString(returnJson, Student.class);
        assertNotNull("Update user password fail", updatedUser);
    }

    @Test
    public void testDelete() {
        Response response = doDelete(BASE_PATH + "entity/" + user.getId(), adminToken);
        assertEquals("Delete user fail", Status.OK.getStatusCode(), response.getStatus());
    }
}
