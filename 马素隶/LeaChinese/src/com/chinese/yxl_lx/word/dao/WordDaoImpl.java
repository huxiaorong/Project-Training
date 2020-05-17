package com.chinese.yxl_lx.word.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinese.entity.User;
import com.chinese.entity.Word;
import com.chinese.yxl_lx.user.dao.UserDaoImpl;
import com.chinese.yxl_lx.util.BaseDao;
import com.chinese.yxl_lx.util.Constant;
import com.chinese.yxl_lx.util.Page;



@Repository
public class WordDaoImpl extends BaseDao<Word, Integer> {
	public Page<Word> findWords(int pageNum, int pageSize,int tag) {
		try {
				return super.findPageByProperty(pageNum, pageSize,
						"from Word w where w.tag=?",
						new Object[] {tag});
			
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
	public int countWordsByTag(int tag) {
		try {
			return super.findByProperty("from Word w where w.tag=?", new Object[] {tag}).size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public List<Word> queryLearnedWords(User user) {
		int page = user.getStudiedTag();
		int tag = user.getLevelTag();
		int num = user.getNumberTag(); 
		try {
			if((page-1)*Constant.PAGE_SIZE+num<=0) {
				return null;
			}else {
				return super.findPageByProperty(1, (page-1)*Constant.PAGE_SIZE+num,
						"from Word w where w.tag=?",
						new Object[] {tag}).getList();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Word> queryNotLearnedWords(User user) {
		int page = user.getStudiedTag();
		int tag = user.getLevelTag();
		int num = user.getNumberTag(); 
		int sum = countWordsByTag(tag);
		try {
			return super.findPageByProperty(1, sum-((page-1)*Constant.PAGE_SIZE+num),
					"from Word w where w.tag=? order by id desc",
					new Object[] {tag}).getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
