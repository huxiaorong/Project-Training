package com.chinese.findgame.dao;

import org.springframework.stereotype.Repository;

import com.chinese.entity.Word;
import com.chinese.util.BaseDaow;

@Repository
public class WordDaow extends BaseDaow<Word, String>{

	public Word findLikeWord(int findLevel){
		try {
			return this.findOne("from Word where findLevel=? order by rand()", new Object[] {findLevel});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
