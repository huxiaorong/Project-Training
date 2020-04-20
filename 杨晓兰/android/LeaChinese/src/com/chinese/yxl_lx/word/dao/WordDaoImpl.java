package com.chinese.yxl_lx.word.dao;

import org.springframework.stereotype.Repository;

import com.chinese.entity.Word;
import com.chinese.yxl_lx.util.BaseDao;
import com.chinese.yxl_lx.util.Page;



@Repository
public class WordDaoImpl extends BaseDao<Word, Integer> {
	public Page<Word> findWords(int pageNum, int pageSize) {
		try {
				return super.findPageByProperty(pageNum, pageSize,
						"from Word",
						new Object[] {});
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Word findOne(int id) {
		try {
			return super.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
