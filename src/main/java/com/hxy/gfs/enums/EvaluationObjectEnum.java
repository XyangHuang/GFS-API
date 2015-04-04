package com.hxy.gfs.enums;

/**
 * 评价对象
 * @author Administrator
 *
 */
public enum EvaluationObjectEnum
{
    SCHOOL(1),
    
    EMPLOYER(2),
    
    STUDENT(3);
    
    private int value;
    
    private EvaluationObjectEnum(int value)
    {
        this.value = value;
    }
    
    public int value()
    {
        return value;
    }
}
