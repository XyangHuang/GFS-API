package com.hxy.gfs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.model.BaseAccount;
import com.hxy.gfs.model.EmployerAdmin;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.repository.BaseAccountRepository;
import com.hxy.gfs.repository.EmployerAdminRepository;
import com.hxy.gfs.repository.StudentRepository;
import com.hxy.gfs.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Resource
    private BaseAccountRepository baseAccountRepository;
    
    @Resource
    private StudentRepository studentRepository;
    
    @Resource
    private EmployerAdminRepository employerAdminRepository;

    @Override
    @Transactional
    public Account create(Account user)
    {
        if (user != null)
        {
            BaseAccount baseAccount = new BaseAccount();
            baseAccount.copyFromAccount(user);
            
            baseAccountRepository.save(baseAccount);
            user.setBaseAccountId(baseAccount.getId());
            
            if (user instanceof Student)
            {
                user = studentRepository.save((Student)user);
            }
            else if (user instanceof EmployerAdmin)
            {
                user = employerAdminRepository.save((EmployerAdmin)user);
            }
            else
            {
                // 系统管理员 Nothing to do
            }
        }
        
        return user;
    }
//
//    @Override
//    @Transactional
//    public Account update(Account user)
//    {
//        return studentRepository.save(user);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(long id)
//    {
//        studentRepository.delete(id);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Student getByUserName(String username)
//    {
//        return studentRepository.getUserByUserName(username);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Student getById(long id)
//    {
//        return studentRepository.findOne(id);
//    }
//
//    @Override
//    public void deleteByIdLogically(long id)
//    {
//        Student user = studentRepository.findOne(id);
//
//        if (user != null)
//        {
//            user.setMarkForDelete(true);
//            studentRepository.save(user);
//        }
//    }
//
//    @Override
//    public List<Student> getUsers()
//    {
//        return studentRepository.getUsers();
//    }
}
