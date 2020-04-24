package com.chinese.yxl_lx.word.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.Word;
import com.chinese.entity.WrongWord;
import com.chinese.yxl_lx.util.Page;
import com.chinese.yxl_lx.word.dao.WordDaoImpl;
import com.chinese.yxl_lx.word.dao.WrongWordDaoImpl;

@Service
@Transactional(readOnly=false)
public class WordServiceImpl {
	@Resource
	private WordDaoImpl wordDaoImpl;
	
	@Resource
	private WrongWordDaoImpl wrongWordDaoImpl;
	
	public Page<Word> listWords(int pageNum,int pageSize){
		return wordDaoImpl.findWords(pageNum, pageSize);
	}
	
	public Word getWord(int id) {
		return this.wordDaoImpl.findOne(id);
	}
	
	public void addWrongWord (WrongWord wrongWord) {
		this.wrongWordDaoImpl.saveWrongWord(wrongWord);
	}
}
