package com.hxy.gfs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.hxy.gfs.model.container.Department;

@Entity
@Table(name = "employer")
@JsonRootName("employer")
public class Employer extends Department implements Serializable
{
    private static final long serialVersionUID = -7778238844997473487L;
}
