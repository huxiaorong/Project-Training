package com.chinese.yxl_lx.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.Collection;
import com.chinese.entity.User;
import com.chinese.entity.UserProgress;
import com.chinese.yxl_lx.user.dao.CollectionDaoImpl;
import com.chinese.yxl_lx.user.dao.UserDaoImpl;
import com.chinese.yxl_lx.user.dao.UserProgressDaoImpl;

@Service
@Transactional(readOnly=false)
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	
	@Resource
	private UserProgressDaoImpl userProgressDaoImpl;
	
	
	@Resource
	private CollectionDaoImpl collectionDaoImpl;

	public void updateUser(User user) {
		this.userDaoImpl.updateUser(user);
	} 
	
	public void updateUserProgress(UserProgress userProgress) {
		this.userProgressDaoImpl.updateUserProgress(userProgress);
	}
	
	public User getUser(int id) {
		return this.userDaoImpl.findUser(id);
	}
	
	public UserProgress getProgress(User user) {
		return this.userProgressDaoImpl.getUserProgress(user);
	}
	
	
	
	public void addCollection(Collection collection) {
		this.collectionDaoImpl.saveCollection(collection);
	}
	
}
