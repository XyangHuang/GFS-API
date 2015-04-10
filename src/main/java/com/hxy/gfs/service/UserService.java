package com.hxy.gfs.service;

import java.util.List;

import com.hxy.gfs.model.container.Account;
import com.hxy.gfs.model.container.ChangePasswordForm;

public interface UserService {

    public Account create(Account user);

    public Account update(Account user);

    public Account getByUserName(String userName);
    
    public Account getById(long sid);
    
    public void changePassword(ChangePasswordForm changePasswordForm);
    
    public void deleteById(long sid);
    
    public void deleteByIdLogically(long sid);
    
    public List<Account> getUsers();
}
