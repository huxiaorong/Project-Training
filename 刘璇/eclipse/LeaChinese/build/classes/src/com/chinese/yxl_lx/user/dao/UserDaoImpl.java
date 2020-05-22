package com.chinese.yxl_lx.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.chinese.entity.User;
import com.chinese.yxl_lx.util.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao<User, Integer>{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void updateUser(User user) {
//		Session session = this.sessionFactory.getCurrentSession();		
//		session.save(user);
//		session.flush();
		try {
			super.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("updateUser"+user.getNumberTag());
//		try {
//			super.excuteBySql("update user set numberTag=? where id = ?", new Object[] {user.getNumberTag(),user.getId()});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	public User findUser(int id) {
		try {
			User user = super.get(id);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
