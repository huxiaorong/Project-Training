package com.example.administrator.leachinese;

public class Word {
    private int id;
    private String word;
    private String pinyin;
    private String audio;
    private String explanation;
    private String sentence1;
    private String sentence2;
    private String sentence3;

    public Word(){

    }
    public Word(int id,String word,String pinyin,String audio,String explanation,
                String sentence1,String sentence2,String sentence3){
        this.id = id;
        this.word = word;
        this.pinyin = pinyin;
        this.audio = audio;
        this.explanation = explanation;
        this.sentence1 = sentence1;
        this.sentence2 = sentence2;
        this.sentence3 = sentence3;
    }

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

    @Override
    public String toString() {
        return "Word{"+
                "id="+id+
                "word="+word+"/"+
                "pinyin="+pinyin+"/"+
                "audio="+audio+"/"+
                "explanation="+explanation+"/"+
                "sentence1="+sentence1+"/"+
                "sentence2="+sentence2+"/"+
                "sentence3="+sentence3+"}";
    }
}
