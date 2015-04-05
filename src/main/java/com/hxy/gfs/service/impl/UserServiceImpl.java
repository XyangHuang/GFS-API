package com.hxy.gfs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxy.gfs.enums.UserRole;
import com.hxy.gfs.model.BaseAccount;
import com.hxy.gfs.model.EmployerAdmin;
import com.hxy.gfs.model.ProfessionAdmin;
import com.hxy.gfs.model.Student;
import com.hxy.gfs.model.SystemAdmin;
import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.repository.BaseAccountRepository;
import com.hxy.gfs.repository.EmployerAdminRepository;
import com.hxy.gfs.repository.ProfessionAdminRepository;
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

    @Resource
    private ProfessionAdminRepository professionAdminRepository;

    @Override
    @Transactional
    public Account create(Account user) // 返回的user是传进来的user
    {
        if (user != null)
        {
            try
            {
                BaseAccount baseAccount = new BaseAccount();
                baseAccount.copyFromAccount(user);

                baseAccountRepository.save(baseAccount);
                user.setBaseAccountId(baseAccount.getId());

                if (user instanceof Student)
                {
                    user = studentRepository.save((Student) user);
                } else if (user instanceof EmployerAdmin)
                {
                    user = employerAdminRepository.save((EmployerAdmin) user);
                } else if (user instanceof ProfessionAdmin)
                {
                    user = professionAdminRepository.save((ProfessionAdmin) user);
                } else
                {
                    // 系统管理员 Nothing to do
                }
            } catch (Exception e)
            {
                // TODO 抛异常
                System.out.println(e);
            }
        }

        return user;
    }

    @Override
    @Transactional
    public Account update(Account user)
    {
        if (user != null)
        {
            BaseAccount userInDB = baseAccountRepository.findOne(user.getBaseAccountId());

            if (userInDB == null)
            {
                // TODO 抛异常
                return user;
            }

            try
            {
                BaseAccount baseAccount = new BaseAccount();
                baseAccount.copyFromAccount(user);
                baseAccount.setPassword(userInDB.getPassword()); // 密码不会传过来

                baseAccountRepository.save(baseAccount);
                user.setBaseAccountId(baseAccount.getId());

                if (user instanceof Student)
                {
                    user = studentRepository.save((Student) user);
                } else if (user instanceof EmployerAdmin)
                {
                    user = employerAdminRepository.save((EmployerAdmin) user);
                } else if (user instanceof ProfessionAdmin)
                {
                    user = professionAdminRepository.save((ProfessionAdmin) user);
                } else
                {
                    // 系统管理员 Nothing to do
                }
            } catch (Exception e)
            {
                // TODO 抛异常
            }
        }

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Account getByUserName(String username)
    {
        if (username == null)
        {
            // TODO 抛异常
            return null;
        }
        
        BaseAccount userInDB = baseAccountRepository.getBaseAccountByUserName(username);
        
        if (userInDB == null)
        {
            // TODO 抛异常
            return null;
        }

        try
        {
            Account user = null;

            int role = userInDB.getRole();
            
            switch (role)
            {
                case UserRole.STUDENT:
                    user = studentRepository.getStudentByBaseAccountId(userInDB.getId());
                    break;
                case UserRole.PROFESSION_ADMIN:
                    user = professionAdminRepository.getProfessionAdminByBaseAccountId(userInDB.getId());
                    break;
                case UserRole.EMPLOYER_ADMIN:
                    user = employerAdminRepository.getEmployerAdminByBaseAccountId(userInDB.getId());
                    break;
                case UserRole.SYSTEM_ADMIN:
                    user = new SystemAdmin();
                    break;
                default:
                    user = new Account();
                    break;
            }
            
            user.copyFromBaseAccount(userInDB);
            
            return user;
        } catch (Exception e)
        {
            // TODO 抛异常
        }
        
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Account getById(long id)
    {
        BaseAccount userInDB = baseAccountRepository.findOne(id);
        
        if (userInDB == null)
        {
            // TODO 抛异常
            return null;
        }

        try
        {
            Account user = null;

            int role = userInDB.getRole();
            
            switch (role)
            {
                case UserRole.STUDENT:
                    user = studentRepository.getStudentByBaseAccountId(userInDB.getId());
                    break;
                case UserRole.PROFESSION_ADMIN:
                    user = professionAdminRepository.getProfessionAdminByBaseAccountId(userInDB.getId());
                    break;
                case UserRole.EMPLOYER_ADMIN:
                    user = employerAdminRepository.getEmployerAdminByBaseAccountId(userInDB.getId());
                    break;
                case UserRole.SYSTEM_ADMIN:
                    user = new SystemAdmin();
                    break;
                default:
                    user = new Account();
                    break;
            }
            
            user.copyFromBaseAccount(userInDB);
            
            return user;
        } catch (Exception e)
        {
            // TODO 抛异常
        }
        
        return null;
    }

    @Override
    @Transactional
    public void deleteById(long id)
    {
        BaseAccount userInDB = baseAccountRepository.findOne(id);

        if (userInDB == null)
        {
            // TODO 抛异常
            return;
        }

        try
        {
            baseAccountRepository.delete(userInDB);

            int role = userInDB.getRole();
            
            switch (role)
            {
                case UserRole.STUDENT:
                    studentRepository.deleteByBaseAccountId(id);
                    break;
                case UserRole.PROFESSION_ADMIN:
                    professionAdminRepository.deleteByBaseAccountId(id);
                    break;
                case UserRole.EMPLOYER_ADMIN:
                    employerAdminRepository.deleteByBaseAccountId(id);
                    break;
                default:
                    break;
            }
        } catch (Exception e)
        {
            // TODO 抛异常
        }
    }

    @Override
    public void deleteByIdLogically(long id)
    {
        BaseAccount userInDB = baseAccountRepository.findOne(id);

        if (userInDB == null)
        {
            // TODO 抛异常
            return;
        }

        try
        {
            baseAccountRepository.deleteByIdLogically(id);

            int role = userInDB.getRole();
            
            switch (role)
            {
                case UserRole.STUDENT:
                    studentRepository.deleteByBaseAccountIdLogically(id);
                    break;
                case UserRole.PROFESSION_ADMIN:
                    professionAdminRepository.deleteByBaseAccountIdLogically(id);
                    break;
                case UserRole.EMPLOYER_ADMIN:
                    employerAdminRepository.deleteByBaseAccountIdLogically(id);
                    break;
                default:
                    break;
            }
        } catch (Exception e)
        {
            // TODO 抛异常
        }
    }

    @Override
    public List<Account> getUsers()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updatePassword(long id, String oldPassword, String newPassword)
    {
        if (oldPassword == null || newPassword == null)
        {
            // TODO 抛异常
            return;
        }
        
        BaseAccount userInDB = baseAccountRepository.findOne(id);
        
        if (userInDB == null)
        {
            // TODO 抛异常 
            return;
        }
        
        if (!oldPassword.equals(userInDB.getPassword()))
        {
            // TODO 抛异常
            return;
        }
        
        try
        {
            baseAccountRepository.updatePassword(id, newPassword);
        } catch (Exception e)
        {
            // TODO 抛异常
            return;
        }
    }

}
