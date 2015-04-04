package com.hxy.gfs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hxy.gfs.constants.Constants;

@MappedSuperclass
public class BaseModel
{
    @Id
    @Column(name = Constants.FIELD_BASE_MODEL_ID, insertable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(Constants.FIELD_BASE_MODEL_ID)
    private long id;

    @Field
    @Column(name = Constants.FIELD_BASE_MODEL_MARK_FOR_DELETE, insertable = false, nullable = false, columnDefinition = "BOOLEAN DEFAULT 0")
    @JsonIgnore
    private boolean markForDelete = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Constants.FIELD_BASE_MODEL_CREATED_TIME, insertable = false, updatable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = Constants.FIELD_BASE_MODEL_LAST_UPDATED_TIME, insertable = false, updatable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @JsonIgnore
    private Date lastUpdatedTime;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public boolean isMarkForDelete()
    {
        return markForDelete;
    }

    public void setMarkForDelete(boolean markForDelete)
    {
        this.markForDelete = markForDelete;
    }

    public Date getCreatedTime()
    {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime)
    {
        this.createdTime = createdTime;
    }

    public Date getLastUpdatedTime()
    {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime)
    {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
