package com.chinese.yxl_lx.user.dao;

import org.springframework.stereotype.Repository;

import com.chinese.entity.Collection;
import com.chinese.yxl_lx.util.BaseDao;

@Repository
public class CollectionDaoImpl extends BaseDao<Collection, Integer> {
	public void saveCollection(Collection collection) {
		try {
			super.save(collection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
