package com.chinese.masuli.idiom.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chinese.entity.Idiom;


@Repository
public class IdiomDao {
	
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 随机查找一个成语
	 * @return
	 */
	public Idiom findByRand(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Idiom order by rand()");
		List<Idiom> idioms = query.list();
		return idioms.get(0);
	}
	
	/**
	 * 判断用户输入是否是一个成语
	 * @param phrase
	 */
	public Idiom isIdiom(String phrase){
		System.out.println(phrase);
		Query query = sessionFactory.getCurrentSession().createQuery("from Idiom where idiom = ?");
		query.setParameter(0, phrase);
		return (Idiom) query.uniqueResult();
	}
	

	/**
	 * 根据最后一个字查找成语
	 * @param phrase 用户输入的成语
	 * @return
	 */
	public List<Idiom> findIdiomByWordS(String phrase) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Idiom where idiom = ?");
		query.setParameter(0, phrase);
		Idiom idiom = (Idiom) query.uniqueResult();
		String pinyinE = idiom.getPinyinE();
		System.out.println(pinyinE);
		Query query1 = sessionFactory.getCurrentSession().createQuery("from Idiom where pinyinS = ?");
		query1.setParameter(0, pinyinE);
		List<Idiom> idioms = query1.list();
		System.out.println(idioms.toString());
		return idioms;
	}
	
 

}
