package com.hxy.gfs.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.annotations.QueryField;
import com.hxy.gfs.constants.Constants;
import com.hxy.gfs.model.container.Account;

@JsonRootName("system_admin")
@QueryField({ Constants.FIELD_BASE_ACCOUNT_USERNAME, Constants.FIELD_BASE_ACCOUNT_PASSWORD })
public class SystemAdmin extends Account implements Serializable {

    private static final long serialVersionUID = -3058226900609265985L;
}
