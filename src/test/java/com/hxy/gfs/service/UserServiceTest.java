package com.hxy.gfs.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.model.EmployerAdmin;
import com.hxy.gfs.model.ProfessionAdmin;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.model.SystemAdmin;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.utils.MD5Util;

public class UserServiceTest extends TestBase
{
    @Autowired
    private UserService userService;

    private SystemAdmin systemAdmin;

    private EmployerAdmin employerAdmin;

    private ProfessionAdmin professionAdmin;

    private Student student;

    @Before
    public void setUp()
    {
        systemAdmin = MockUtil.mockSystemAdmin();

        employerAdmin = MockUtil.mockEmployerAdmin();

        professionAdmin = MockUtil.mockProfessionAdmin();

        student = MockUtil.mockStudent();
    }

    @After
    public void tearDown()
    {
        Account userInDB = userService.getById(systemAdmin.getBaseAccountId());

        if (userInDB != null)
        {
            userService.deleteById(systemAdmin.getBaseAccountId());
        }

        userInDB = userService.getById(employerAdmin.getBaseAccountId());

        if (userInDB != null)
        {
            userService.deleteById(employerAdmin.getBaseAccountId());
        }

        userInDB = userService.getById(professionAdmin.getBaseAccountId());

        if (userInDB != null)
        {
            userService.deleteById(professionAdmin.getBaseAccountId());
        }

        userInDB = userService.getById(student.getBaseAccountId());

        if (userInDB != null)
        {
            userService.deleteById(student.getBaseAccountId());
        }
    }

    @Test
    public void testCreateUserAndGetUserById()
    {
        // Test save base account.
        userService.create(systemAdmin);

        Account insertedUser = userService.getById(systemAdmin.getBaseAccountId());

        assertNotNull("Create baseAccount failed", insertedUser);
        assertEquals(systemAdmin.getUserName(), insertedUser.getUserName());
        assertEquals(systemAdmin.getPassword(), insertedUser.getPassword());

        // Test save profession admin;
        userService.create(professionAdmin);

        ProfessionAdmin insertedProfessionAdmin = (ProfessionAdmin) userService.getById(professionAdmin.getBaseAccountId());
        assertNotNull("Create profession admin failed", insertedProfessionAdmin);
        assertEquals(professionAdmin.getUserName(), insertedProfessionAdmin.getUserName());
        assertEquals(professionAdmin.getPassword(), insertedProfessionAdmin.getPassword());

        // Test save employer admin;
        userService.create(employerAdmin);

        EmployerAdmin insertedEmployerAdmin = (EmployerAdmin) userService.getById(employerAdmin.getBaseAccountId());
        assertNotNull("Create EmployerAdmin failed", insertedEmployerAdmin);
        assertEquals(employerAdmin.getUserName(), insertedEmployerAdmin.getUserName());
        assertEquals(employerAdmin.getPassword(), insertedEmployerAdmin.getPassword());

        // Test save student;
        userService.create(student);

        Student insertedStudent = (Student) userService.getById(student.getBaseAccountId());
        assertNotNull("Create student failed", insertedStudent);
        assertEquals(student.getUserName(), insertedStudent.getUserName());
        assertEquals(student.getPassword(), insertedStudent.getPassword());
    }

    @Test
    public void testUpdateUser()
    {
        userService.create(systemAdmin);

        Account insertedUser = userService.getById(systemAdmin.getId());
        assertNotNull("Create user failed", insertedUser);

        insertedUser.setPassword(MD5Util.getMd5("111111"));
        Account updatedUser = userService.update(insertedUser);

        assertNotNull("Update user failed", updatedUser);
        assertEquals(insertedUser.getUserName(), updatedUser.getUserName());
        assertEquals(insertedUser.getPassword(), updatedUser.getPassword());
    }

    @Test
    public void testGetUserByUserName()
    {
        userService.create(systemAdmin);

        Account insertedUser = userService.getByUserName(systemAdmin.getUserName());
        assertNotNull("Create user failed", insertedUser);
        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
    }

    @Test
    public void testDeleteUser()
    {
        userService.create(systemAdmin);

        Account insertedUser = userService.getByUserName(systemAdmin.getUserName());
        assertNotNull("Create user failed", insertedUser);

        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());

        userService.deleteById(systemAdmin.getId());
        insertedUser = userService.getByUserName(systemAdmin.getUserName());
        org.junit.Assert.assertTrue(insertedUser == null);
    }

    @Test
    public void testDeleteUserByIdLogically()
    {
        userService.create(systemAdmin);

        Account insertedUser = userService.getByUserName(systemAdmin.getUserName());
        assertNotNull("Create user failed", insertedUser);
        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());

        userService.deleteById(systemAdmin.getId());
        insertedUser = userService.getByUserName(systemAdmin.getUserName());
        org.junit.Assert.assertTrue(insertedUser == null);
    }
}
