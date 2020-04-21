package com.chinese.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "word")
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String word;
    private String pinyin;
    private String explanation;
    private String tag;
    private int findlevel;
    private String likeword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

   

    public int getFindlevel() {
		return findlevel;
	}

	public void setFindlevel(int findlevel) {
		this.findlevel = findlevel;
	}

	public String getLikeword() {
        return likeword;
    }

    public void setLikeword(String likeword) {
        this.likeword = likeword;
    }

	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", pinyin=" + pinyin + ", explanation=" + explanation + ", tag="
				+ tag + ", findlevel=" + findlevel + ", likeword=" + likeword + "]";
	}

   
}
