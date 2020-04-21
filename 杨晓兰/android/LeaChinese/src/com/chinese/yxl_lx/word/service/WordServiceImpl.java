package com.chinese.yxl_lx.word.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.Word;
import com.chinese.yxl_lx.util.Page;
import com.chinese.yxl_lx.word.dao.WordDaoImpl;

@Service
@Transactional(readOnly=true)
public class WordServiceImpl {
	@Resource
	private WordDaoImpl wordDaoImpl;
	
	public Page<Word> listWords(int pageNum,int pageSize){
		return wordDaoImpl.findWords(pageNum, pageSize);
	}
	
	public Word getWord(int id) {
		return this.wordDaoImpl.findOne(id);
	}
}
