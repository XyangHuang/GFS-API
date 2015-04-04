package com.hxy.gfs.enums;

public enum UserRoleEnum
{
    ALL(1),
    
    SYSTEM_ADMIN(2),
    
    PROFESSION_ADMIN(3),
    
    EMPLOYER_ADMIN(4),
    
    STUDENT(5);
    
    private int value;
    
    private UserRoleEnum(int value)
    {
        this.value = value;
    }
    
    public int value()
    {
        return value;
    }
}
