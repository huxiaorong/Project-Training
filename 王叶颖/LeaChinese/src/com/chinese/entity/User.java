package com.chinese.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GenericGenerator(name = "myassigned", strategy = "assigned")
	@GeneratedValue(generator = "myassigned")
	private int id;
	
	private String userName;
	private int goalTime;
	private int reviewedTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getGoalTime() {
		return goalTime;
	}
	public void setGoalTime(int goalTime) {
		this.goalTime = goalTime;
	}
	public int getReviewedTime() {
		return reviewedTime;
	}
	public void setReviewedTime(int reviewedTime) {
		this.reviewedTime = reviewedTime;
	}

}
