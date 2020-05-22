package com.chinese.yxl_lx.word.dao;

import org.springframework.stereotype.Repository;

import com.chinese.entity.WrongWord;
import com.chinese.yxl_lx.util.BaseDao;

@Repository
public class WrongWordDaoImpl extends BaseDao<WrongWord, Integer> {
	
	public void saveWrongWord(WrongWord wrongWord) {
		try {
			super.save(wrongWord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
