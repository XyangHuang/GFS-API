package com.hxy.gfs.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxy.gfs.MockUtil;
import com.hxy.gfs.enums.UserRole;
import com.hxy.gfs.model.EmployerAdmin;
import com.hxy.gfs.model.ProfessionAdmin;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.utils.MD5Util;

public class UserServiceTest extends TestBase
{
    @Autowired
    private UserService userService;
    
    private Account baseAccount;

    @Before
    public void setUp()
    {
        baseAccount = MockUtil.mockUser();
    }

    @After
    public void tearDown()
    {
        Account userInDB = userService.getById(baseAccount.getId());
        
        if (userInDB != null)
        {
            userService.deleteById(baseAccount.getId());
        }
    }

    @Test
    public void testCreateUserAndGetUserById()
    {
        // Test save base account.
        userService.create(baseAccount);

        Account insertedUser = userService.getById(baseAccount.getId());

        assertNotNull("Create baseAccount failed", insertedUser);
        assertEquals(baseAccount.getUserName(), insertedUser.getUserName());
        assertEquals(baseAccount.getPassword(), insertedUser.getPassword());
        
        // Test save student;
        Student student = (Student)baseAccount;
        student.setRole(UserRole.STUDENT);
        userService.create(student);
        
        Student insertedStudent = (Student)userService.getById(student.getBaseAccountId());
        assertNotNull("Create student failed", insertedStudent);
        assertEquals(student.getUserName(), insertedStudent.getUserName());
        assertEquals(student.getPassword(), insertedStudent.getPassword());

        // Test save profession admin;
        ProfessionAdmin professionAdmin = (ProfessionAdmin)baseAccount;
        professionAdmin.setRole(UserRole.PROFESSION_ADMIN);
        userService.create(professionAdmin);
        
        ProfessionAdmin insertedProfessionAdmin = (ProfessionAdmin)userService.getById(professionAdmin.getBaseAccountId());
        assertNotNull("Create profession admin failed", insertedProfessionAdmin);
        assertEquals(professionAdmin.getUserName(), insertedProfessionAdmin.getUserName());
        assertEquals(professionAdmin.getPassword(), insertedProfessionAdmin.getPassword());

        // Test save employer admin;
        EmployerAdmin employerAdmin = (EmployerAdmin)baseAccount;
        employerAdmin.setRole(UserRole.EMPLOYER_ADMIN);
        userService.create(student);
        
        EmployerAdmin insertedEmployerAdmin = (EmployerAdmin)userService.getById(employerAdmin.getBaseAccountId());
        assertNotNull("Create EmployerAdmin failed", insertedEmployerAdmin);
        assertEquals(employerAdmin.getUserName(), insertedEmployerAdmin.getUserName());
        assertEquals(employerAdmin.getPassword(), insertedEmployerAdmin.getPassword());
    }

    @Test
    public void testUpdateUser()
    {
        userService.create(baseAccount);

        Account insertedUser = userService.getById(baseAccount.getId());
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
        userService.create(baseAccount);

        Account insertedUser = userService.getByUserName(baseAccount.getUserName());
        assertNotNull("Create user failed", insertedUser);
        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
    }

    @Test
    public void testDeleteUser()
    {
        userService.create(baseAccount);

        Account insertedUser = userService.getByUserName(baseAccount.getUserName());
        assertNotNull("Create user failed", insertedUser);

        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
        
        userService.deleteById(baseAccount.getId());
        insertedUser = userService.getByUserName(baseAccount.getUserName());
        org.junit.Assert.assertTrue(insertedUser == null);
    }

    @Test
    public void testDeleteUserByIdLogically()
    {
        userService.create(baseAccount);

        Account insertedUser = userService.getByUserName(baseAccount.getUserName());
        assertNotNull("Create user failed", insertedUser);
        assertEquals(insertedUser.getUserName(), insertedUser.getUserName());
        assertEquals(insertedUser.getPassword(), insertedUser.getPassword());
        
        userService.deleteById(baseAccount.getId());
        insertedUser = userService.getByUserName(baseAccount.getUserName());
        org.junit.Assert.assertTrue(insertedUser == null);
    }
}
