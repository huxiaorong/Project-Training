package com.chinese.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.chinese.entity.Question_Tingyinshizi;

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
	
	public List<Question_Tingyinshizi> tingtyinshizi(int id){
		
		return null;
		
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
