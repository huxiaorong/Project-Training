package com.chinese.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "record")
public class Record {
    private int id;
    private int userId;
    private Date studiedTime;

    public Record(){}
    
    public Record(int id,int userId,Date studiedTime){
        this.id =id;
        this.userId = userId;
        this.studiedTime = studiedTime;
    }
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStudiedTime() {
        return studiedTime;
    }

    public void setStudiedTime(Date studiedTime) {
        this.studiedTime = studiedTime;
    }

    @Override
    public String toString() {
        return "Calendar{"+"id="+id+"userId="+userId+"studiedTime="+studiedTime+"}";
    }
}
