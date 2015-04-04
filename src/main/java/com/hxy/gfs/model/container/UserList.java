package com.hxy.gfs.model.container;

import java.util.ArrayList;
import java.util.Collection;

import com.hxy.gfs.model.Student;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("users")
public class UserList extends ArrayList<Student> {

    private static final long serialVersionUID = -2220327054422493413L;

    public UserList(Collection<? extends Student> u) {
        super(u);
    }

    public UserList() {

    }

}
