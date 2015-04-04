package com.hxy.gfs.enums;

public enum QuestionnaireStatus
{
    UNASSIGNED((byte)1),
    
    ACTIVE((byte)2),
    
    COMPLETED((byte)3);
    
    private byte status;
    
    private QuestionnaireStatus(byte status)
    {
        this.status = status;
    }
    
    public byte value()
    {
        return status;
    }
}
