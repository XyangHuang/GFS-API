package com.hxy.gfs.enums;

public enum QuestionType
{
    /**
     * 单选题
     */
    ONE_CHOICE((byte)1),
    
    /**
     * 多选题
     */
    MUTIPLE_CHOICE((byte)2),
    
    /**
     * 填空题
     */
    COMPLETION((byte)3),
    
    /**
     * 问答题
     */
    ESSAY((byte)4),;
    
    private byte mValue;
    
    private QuestionType(byte value)
    {
        this.mValue = value;
    }
    
    public byte value()
    {
        return mValue;
    }
}
