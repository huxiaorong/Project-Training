package com.chinese.weixinxin.findgame.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.Word;
import com.chinese.weixinxin.findgame.dao.WordDaow;


@Service
@Transactional(readOnly = true)
public class WordServicew {
	@Resource
	private WordDaow wordDao;
	
	public Word findLikeWord(int findLevel){
		return wordDao.findLikeWord(findLevel);
	}

}
