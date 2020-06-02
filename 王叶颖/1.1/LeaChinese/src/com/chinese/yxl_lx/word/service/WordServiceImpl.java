package com.chinese.yxl_lx.word.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.User;
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
	
	public Page<Word> listWords(int pageNum,int pageSize,int tag){
		return wordDaoImpl.findWords(pageNum, pageSize,tag);
	}
	
	public Word getWord(int id) {
		return this.wordDaoImpl.findOne(id);
	}
	
	public void addWrongWord (WrongWord wrongWord) {
		this.wrongWordDaoImpl.saveWrongWord(wrongWord);
	}
	
	public int countWordsByTag(int tag) {
		return this.wordDaoImpl.countWordsByTag(tag);
	}
	
	public List<Word> findLearnedWords(User user) {
		return this.wordDaoImpl.queryLearnedWords(user);
	}
	
	public List<Word> findNotLearnedWords(User user) {
		return this.wordDaoImpl.queryNotLearnedWords(user);
	}
}
