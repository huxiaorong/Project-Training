package com.chinese.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="level")
public class Level {
	private int id;
	private String levelName;
	private String img;
	
	public Level(){}
	
	public Level(int id,String levelName){
		this.id = id;
		this.levelName = levelName;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Level{"+"id:"+id+"levelName:"+levelName+"img:"+img+"}";
	}

	
}
