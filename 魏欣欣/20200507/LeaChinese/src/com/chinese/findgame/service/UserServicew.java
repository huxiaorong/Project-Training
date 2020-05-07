package com.chinese.findgame.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.User;
import com.chinese.findgame.dao.UserDaow;


@Service
@Transactional(readOnly= false)
public class UserServicew {
	@Resource
	private UserDaow userDao;
	
	public void saveUserLevelGuan(User user){
		userDao.saveUserLevelGuan(user);
	}

}
