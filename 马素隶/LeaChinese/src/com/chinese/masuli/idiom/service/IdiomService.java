package com.chinese.masuli.idiom.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinese.entity.Idiom;
import com.chinese.masuli.idiom.dao.IdiomDao;

@Service
public class IdiomService {
	
	@Resource
	private IdiomDao idiomDao;
	
	public Idiom findIdiomRand() {
		return idiomDao.findByRand();
	}
	
	public Idiom isIdiom(String phrase) {
		return idiomDao.isIdiom(phrase);
	}
	
	public Idiom findIdiomByWordS(String phrase) {
		return idiomDao.findIdiomByWordS(phrase);
	}
}
