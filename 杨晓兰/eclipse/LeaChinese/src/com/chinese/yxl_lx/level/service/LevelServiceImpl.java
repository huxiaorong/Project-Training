package com.chinese.yxl_lx.level.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.Level;
import com.chinese.yxl_lx.level.dao.LevelDaoImpl;

@Service
@Transactional(readOnly = true)
public class LevelServiceImpl {
	
	@Resource
	private LevelDaoImpl levelDaoImpl;
	
	public List<Level> findLevelbooks(){
		return levelDaoImpl.findLevels();
	}
}
