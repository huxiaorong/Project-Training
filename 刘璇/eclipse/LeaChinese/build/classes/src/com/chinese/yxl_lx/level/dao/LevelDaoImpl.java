package com.chinese.yxl_lx.level.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinese.entity.Level;
import com.chinese.yxl_lx.util.BaseDao;


@Repository
public class LevelDaoImpl extends BaseDao<Level,Integer>{
	public List<Level> findLevels(){
		try {
			return super.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
