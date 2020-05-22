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
    private String pinyin;
    private String audio;
    private String explanation;
    private String sentence1;
    private String pinyin1;
    private String sentence2;
    private String pinyin2;
    private String sentence3;
    private String pinyin3;
    private int tag;
    private int findlevel;
    private String likeword;

    public Word(){

    }
    
    
    
    public Word(int id, String word, String pinyin, String audio, String explanation, String sentence1, String pinyin1,
			String sentence2, String pinyin2, String sentence3, String pinyin3, int tag) {
		super();
		this.id = id;
		this.word = word;
		this.pinyin = pinyin;
		this.audio = audio;
		this.explanation = explanation;
		this.sentence1 = sentence1;
		this.pinyin1 = pinyin1;
		this.sentence2 = sentence2;
		this.pinyin2 = pinyin2;
		this.sentence3 = sentence3;
		this.pinyin3 = pinyin3;
		this.tag = tag;
	}



	public Word(int id, String word, String pinyin, String audio, String explanation, String sentence1, String pinyin1,
			String sentence2, String pinyin2, String sentence3, String pinyin3, int tag, int findlevel,
			String likeword) {
		super();
		this.id = id;
		this.word = word;
		this.pinyin = pinyin;
		this.audio = audio;
		this.explanation = explanation;
		this.sentence1 = sentence1;
		this.pinyin1 = pinyin1;
		this.sentence2 = sentence2;
		this.pinyin2 = pinyin2;
		this.sentence3 = sentence3;
		this.pinyin3 = pinyin3;
		this.tag = tag;
		this.findlevel = findlevel;
		this.likeword = likeword;
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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
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
    public String getPinyin1() {
        return pinyin1;
    }

    public void setPinyin1(String pinyin1) {
        this.pinyin1 = pinyin1;
    }

    public String getPinyin2() {
        return pinyin2;
    }

    public void setPinyin2(String pinyin2) {
        this.pinyin2 = pinyin2;
    }

    public String getPinyin3() {
        return pinyin3;
    }

    public void setPinyin3(String pinyin3) {
        this.pinyin3 = pinyin3;
    }

	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", pinyin=" + pinyin + ", audio=" + audio + ", explanation="
				+ explanation + ", sentence1=" + sentence1 + ", pinyin1=" + pinyin1 + ", sentence2=" + sentence2
				+ ", pinyin2=" + pinyin2 + ", sentence3=" + sentence3 + ", pinyin3=" + pinyin3 + ", tag=" + tag
				+ ", findlevel=" + findlevel + ", likeword=" + likeword + "]";
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
