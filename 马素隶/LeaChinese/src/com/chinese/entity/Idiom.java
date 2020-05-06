package com.chinese.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "idioms")
public class Idiom {
	//唯一标识
	private int id;
	//成语
	private String idiom;
	//成语的第一个字
	private String wordS;
	//成语的最后一个字
	private String wordE;
	//成语第一个字的拼音
	private String pinyinS;
	//成语最后一个字的拼音
	private String pinyinE;
	//成语解释
	private String paraphrase;
	//成语拼音
	private String pinyin;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdiom() {
		return idiom;
	}
	public void setIdiom(String idiom) {
		this.idiom = idiom;
	}
	public String getWordS() {
		return wordS;
	}
	public void setWordS(String wordS) {
		this.wordS = wordS;
	}
	public String getWordE() {
		return wordE;
	}
	public void setWordE(String wordE) {
		this.wordE = wordE;
	}
	public String getPinyinS() {
		return pinyinS;
	}
	public void setPinyinS(String pinyinS) {
		this.pinyinS = pinyinS;
	}
	public String getPinyinE() {
		return pinyinE;
	}
	public void setPinyinE(String pinyinE) {
		this.pinyinE = pinyinE;
	}
	public String getParaphrase() {
		return paraphrase;
	}
	public void setParaphrase(String paraphrase) {
		this.paraphrase = paraphrase;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	@Override
	public String toString() {
		return "Idiom [id=" + id + ", idiom=" + idiom + ", wordS=" + wordS + ", wordE=" + wordE + ", pinyinS=" + pinyinS
				+ ", pinyinE=" + pinyinE + ", paraphrase=" + paraphrase + ", pinyin=" + pinyin + "]";
	}
	
	
	
	
}
