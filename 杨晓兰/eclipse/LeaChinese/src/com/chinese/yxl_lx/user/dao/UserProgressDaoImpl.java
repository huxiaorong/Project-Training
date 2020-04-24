package com.chinese.yxl_lx.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chinese.entity.User;
import com.chinese.entity.UserProgress;
import com.chinese.yxl_lx.util.BaseDao;

@Repository
public class UserProgressDaoImpl extends BaseDao<UserProgress, Integer>{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public UserProgress getUserProgress(User user) {
		try {
			UserProgress userProgress = super.findOne("from UserProgress up where up.userId = ? and up.levelTag = ?"
					, new Object[] {user.getId(),user.getLevelTag()});
			return userProgress;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	public void updateUserProgress(UserProgress userProgress) {
		try {
			super.update(userProgress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
