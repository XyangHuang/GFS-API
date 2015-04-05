package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.model.container.Department;

@Entity
@Table(name = "profession")
@JsonRootName("profession")
public class Profession extends Department implements Serializable
{
    private static final long serialVersionUID = -5310357347219777144L;
}
