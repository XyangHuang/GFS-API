package com.hxy.gfs.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.repository.BaseAccountRepository;
import com.hxy.gfs.utils.MD5Util;

public class UserRepositoryTest extends TestBase
{
    @Autowired
    private BaseAccountRepository userRepository;
    
    private Student user;

    @Before
    public void setUp()
    {
        user = MockUtil.mockUser();
    }

//    @After
//    public void tearDown()
//    {
//        Student userInDB = userRepository.findOne(user.getId());
//        
//        if (userInDB != null)
//        {
//            userRepository.delete(user.getId());
//        }
//    }
//
//    @Test
//    public void testCreateUserAndGetUserById()
//    {
//        userRepository.save(user);
//
//        Student insertedUser = userRepository.findOne(user.getId());
//
//        assertNotNull("Create user failed", insertedUser);
//        assertEquals(user.getUserName(), insertedUser.getUserName());
//        assertEquals(user.getPassword(), insertedUser.getPassword());
//    }
//
//    @Test
//    public void testUpdateUser()
//    {
//        userRepository.save(user);
//
//        Student insertedUser = userRepository.findOne(user.getId());
//        assertNotNull("Create user failed", insertedUser);
//
//        insertedUser.setPassword(MD5Util.getMd5("111111"));
//        Student updatedUser = userRepository.save(insertedUser);
//
//        assertNotNull("Update user failed", updatedUser);
//        assertEquals(insertedUser.getUserName(), updatedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), updatedUser.getPassword());
//    }
//
//    @Test
//    public void testGetUserByUserName()
//    {
//        userRepository.save(user);
//
//        Student insertedUser = userRepository.getUserByUserName(user.getUserName());
//        assertNotNull("Create user failed", insertedUser);
//        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
//    }
//
//    @Test
//    public void testDeleteUser()
//    {
//        userRepository.save(user);
//
//        Student insertedUser = userRepository.getUserByUserName(user.getUserName());
//        assertNotNull("Create user failed", insertedUser);
//
//        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
//        
//        userRepository.delete(user.getId());
//        insertedUser = userRepository.getUserByUserName(user.getUserName());
//        org.junit.Assert.assertTrue(insertedUser == null);
//    }
//
//    @Test
//    public void testDeleteUserByIdLogically()
//    {
//        userRepository.save(user);
//
//        Student insertedUser = userRepository.getUserByUserName(user.getUserName());
//        assertNotNull("Create user failed", insertedUser);
//        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
//        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
//        
//        userRepository.delete(user.getId());
//        insertedUser = userRepository.getUserByUserName(user.getUserName());
//        org.junit.Assert.assertTrue(insertedUser == null);
//    }
}
