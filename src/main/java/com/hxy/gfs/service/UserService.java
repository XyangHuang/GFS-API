package com.hxy.gfs.service;

import java.util.List;

import com.hxy.gfs.model.container.Account;

public interface UserService {

    public Account create(Account user);

    public Account update(Account user);

    public Account getByUserName(String userName);
    
    public Account getById(long sid);
    
    public void updatePassword(long id, String oldPassword, String newPassword);

    public void deleteById(long sid);
    
    public void deleteByIdLogically(long sid);
    
    public List<Account> getUsers();
}
