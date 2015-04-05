package com.hxy.gfs.enums;

public enum SortByEnum
{
    USERNAME("userName"),
    
    CREATEDTIME("createdTime"),
    
    ITEMNAME("itemName"),
    
    PRICE("price"),
    
    COLLECTION_NUMBER("collectionNumber");

    private String value;

    private SortByEnum(String value)
    {
        this.value = value;
    }

    public String value()
    {
        return value;
    }

    public static SortByEnum fromValue(String value)
    {
        for (SortByEnum sortByEnum : SortByEnum.values())
        {
            if (sortByEnum.value.equals(value))
            {
                return sortByEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
