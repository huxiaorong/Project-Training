package com.chinese.weixinxin.findgame.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.chinese.entity.User;

@Repository
public class UserDaow{

	@Resource
	private SessionFactory sessionFactory;
	
	public void saveUserLevelGuan(User user){
		
		Session session = this.sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		User user2=session.get(User.class, new Integer(user.getId()));
		System.out.println("mmmmm"+user2);
		user2.setLevelone(user.getLevelone());
		user2.setLeveltwo(user.getLeveltwo());
		user2.setLevelthree(user.getLevelthree());
		System.out.println("wwww"+user2);
		session.save(user2);
		t.commit();
	}
}
