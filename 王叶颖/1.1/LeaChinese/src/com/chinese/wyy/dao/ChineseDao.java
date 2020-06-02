package com.chinese.wyy.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chinese.entity.Question_Tingyinshizi;
import com.chinese.entity.Question_hanzishiyin;

@Repository
public class ChineseDao {
	
	@Resource
	SessionFactory sessionFactory;
	
	public List<Integer> selectTime(int id){
		List<Integer> timeList = new ArrayList<>();
		int goalTime = 0;
		int reviewedTime = 0;
		goalTime = (int) this.sessionFactory.getCurrentSession().createQuery("select goalTime from User where id = ?")
				.setParameter(0, id).uniqueResult();
		timeList.add(goalTime);
		reviewedTime = (int) this.sessionFactory.getCurrentSession().createQuery("select reviewedTime from User where id = ?")
				.setParameter(0, id).uniqueResult();
		timeList.add(reviewedTime);
		return timeList;
	}
	
	public List<Integer> selectWrongWord(int id){
		List<Integer> list = new ArrayList<>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("select wordId from WrongWord "
				+ "where userId = ? order by reviewed_times").setParameter(0, id);
		query.setFirstResult(0);
		query.setMaxResults(3);
		list = query.list();
		return list;
	}
	
	public List<Question_Tingyinshizi> questionTing(List<Integer> list){
		List<Question_Tingyinshizi> qlist = new ArrayList<>();
		Question_Tingyinshizi q = new Question_Tingyinshizi();
		for(Integer l:list){
			q = (Question_Tingyinshizi) this.sessionFactory.getCurrentSession()
					.createQuery("from Question_Tingyinshizi where wordId = ? ").setParameter(0, l).uniqueResult();
			qlist.add(q);
		}
		return qlist;
	}
	
	public List<Question_hanzishiyin> questionHan(List<Integer> list){
		List<Question_hanzishiyin> qlist = new ArrayList<>();
		Question_hanzishiyin q = new Question_hanzishiyin();
		for(Integer l:list){
			q = (Question_hanzishiyin) this.sessionFactory.getCurrentSession()
					.createQuery("from Question_hanzishiyin where wordId = ? ").setParameter(0, l).uniqueResult();
			qlist.add(q);
		}
		return qlist;
	}
	
	public void updateCount(int count,int userId){
		Query query = this.sessionFactory.getCurrentSession()
			.createQuery("update User set todaycount = ?+todaycount where id = ?")
			.setParameter(0, count).setParameter(1, userId);
		query.executeUpdate();
	}
	
	public int getTodaysCount(int id){
		int count;
		count = (int) this.sessionFactory.getCurrentSession().createQuery("select todaycount from User where id = ?")
				.setParameter(0, id).uniqueResult();
		return count;
	}
	
	
	
	
//	public Set<String> queryBrand(){
//		Query query = this.sessionFactory.getCurrentSession().createQuery("select brand from Piano");
//		Set brands = new HashSet(query.list());
//		return brands;
//	}
//	
//	public void add(Piano piano){
//		piano.setId(3);
//		this.sessionFactory.getCurrentSession().save(piano);
//	}
//	
//	public Piano queryById(int id){
//		Piano piano = (Piano) this.sessionFactory.getCurrentSession().createQuery("from Piano where id = ?")
//				.setParameter(0, id).uniqueResult();
//		return piano;
//	}
//	
//	public void edit(Piano piano){
//		this.sessionFactory.getCurrentSession().update(piano);
//	}
//	
//	public void delete(int id){
//		this.sessionFactory.getCurrentSession().createQuery("delete Piano where id=?").setParameter(0, id).executeUpdate();
//	}
	    
	

}
