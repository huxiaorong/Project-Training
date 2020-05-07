package com.chinese.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private int levelone;
    private int leveltwo;
    private int levelthree;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevelone() {
		return levelone;
	}
	public void setLevelone(int levelone) {
		this.levelone = levelone;
	}
	public int getLeveltwo() {
		return leveltwo;
	}
	public void setLeveltwo(int leveltwo) {
		this.leveltwo = leveltwo;
	}
	public int getLevelthree() {
		return levelthree;
	}
	public void setLevelthree(int levelthree) {
		this.levelthree = levelthree;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", levelone=" + levelone + ", leveltwo=" + leveltwo + ", levelthree=" + levelthree
				+ "]";
	}

    
}
