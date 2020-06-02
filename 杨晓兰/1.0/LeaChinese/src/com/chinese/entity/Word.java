package com.chinese.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "word")
public class Word {
	private int id;
    private String word;
    private String explanation;
    private String sentence1;
    private String sentence2;
    private String sentence3;
    private int tag;
    private int findlevel;
    private String likeword;

    public Word(){

    }
    
    
    
   



	

	public Word(int id, String word, String explanation, String sentence1, String sentence2, String sentence3, int tag,
			int findlevel, String likeword) {
		super();
		this.id = id;
		this.word = word;
		this.explanation = explanation;
		this.sentence1 = sentence1;
		this.sentence2 = sentence2;
		this.sentence3 = sentence3;
		this.tag = tag;
		this.findlevel = findlevel;
		this.likeword = likeword;
	}









	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", explanation=" + explanation + ", sentence1=" + sentence1
				+ ", sentence2=" + sentence2 + ", sentence3=" + sentence3 + ", tag=" + tag + ", findlevel=" + findlevel
				+ ", likeword=" + likeword + "]";
	}









	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSentence1() {
        return sentence1;
    }

    public void setSentence1(String sentence1) {
        this.sentence1 = sentence1;
    }

    public String getSentence2() {
        return sentence2;
    }

    public void setSentence2(String sentence2) {
        this.sentence2 = sentence2;
    }

    public String getSentence3() {
        return sentence3;
    }

    public void setSentence3(String sentence3) {
        this.sentence3 = sentence3;
    }
    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
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

    
}
