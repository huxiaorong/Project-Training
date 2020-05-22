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
	public Collection selectCollectOrNot(int userId,int wordId){
		String hql = "from Collection where userId = ? and wordId = ?";
		try {
			return super.findOne(hql, new Object[]{userId,wordId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void delectCollect(int userId,int wordId){
		String sql = "delete from collection where userId = ? and wordId = ?";
		try {
			super.excuteBySql(sql, new Object[]{userId,wordId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
