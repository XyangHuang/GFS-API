package com.hxy.gfs.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.service.UserService;
import com.hxy.gfs.utils.MD5Util;

public class UserServiceTest extends TestBase
{
    @Autowired
    private UserService userService;
    
    private Student user;

    @Before
    public void setUp()
    {
        user = MockUtil.mockUser();
    }
//
//    @After
//    public void tearDown()
//    {
//        Student userInDB = userService.getById(user.getId());
//        
//        if (userInDB != null)
//        {
//            userService.deleteById(user.getId());
//        }
//    }
//
//    @Test
//    public void testCreateUserAndGetUserById()
//    {
//        userService.create(user);
//
//        Student insertedUser = userService.getById(user.getId());
//
//        assertNotNull("Create user failed", insertedUser);
//        assertEquals(user.getUserName(), insertedUser.getUserName());
//        assertEquals(user.getPassword(), insertedUser.getPassword());
//    }
//
//    @Test
//    public void testUpdateUser()
//    {
//        userService.create(user);
//
//        Student insertedUser = userService.getById(user.getId());
//        assertNotNull("Create user failed", insertedUser);
//
//        insertedUser.setPassword(MD5Util.getMd5("111111"));
//        Student updatedUser = userService.update(insertedUser);
//
//        assertNotNull("Update user failed", updatedUser);
//        assertEquals(insertedUser.getUserName(), updatedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), updatedUser.getPassword());
//    }
//
//    @Test
//    public void testGetUserByUserName()
//    {
//        userService.create(user);
//
//        Student insertedUser = userService.getByUserName(user.getUserName());
//        assertNotNull("Create user failed", insertedUser);
//        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
//    }
//
//    @Test
//    public void testDeleteUser()
//    {
//        userService.create(user);
//
//        Student insertedUser = userService.getByUserName(user.getUserName());
//        assertNotNull("Create user failed", insertedUser);
//
//        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
//        
//        userService.deleteById(user.getId());
//        insertedUser = userService.getByUserName(user.getUserName());
//        org.junit.Assert.assertTrue(insertedUser == null);
//    }
//
//    @Test
//    public void testDeleteUserByIdLogically()
//    {
//        userService.create(user);
//
//        Student insertedUser = userService.getByUserName(user.getUserName());
//        assertNotNull("Create user failed", insertedUser);
//        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
//        
//        userService.deleteById(user.getId());
//        insertedUser = userService.getByUserName(user.getUserName());
//        org.junit.Assert.assertTrue(insertedUser == null);
//    }
}
