package com.hxy.gfs.enums;

public enum SearchTypeEnum {

    TYPE_DEFAULT_SEARCH("default search"), // Search without sortBy and district
    TYPE_SORTBY_SEARCH("sortBy search"), // Search with sortBy without district
    TYPE_DISTRICT_SEARCH("district search"), // Search with district without sortBy
    TYPE_SORTBY_DISTRICT_SEARCH("sortBy and district search"); // Search with sortBy and district

    private String value;

    private SearchTypeEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static SearchTypeEnum fromValue(String value) {
        for (SearchTypeEnum searchTypeEnum : SearchTypeEnum.values()) {
            if (searchTypeEnum.value.equals(value)) {
                return searchTypeEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
