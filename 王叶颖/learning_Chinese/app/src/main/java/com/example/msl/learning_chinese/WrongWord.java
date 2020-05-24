package com.example.msl.learning_chinese;

import java.util.Date;

public class WrongWord {
    private int id;
    private int wordId;
    private Date time;
    private int userId;

    public WrongWord(){}
    public WrongWord(int id,int wordId,Date time,int userId){
        this.id = id;
        this.wordId = wordId;
        this.time = time;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WrongWord{"+"id="+id+"wordId="+wordId+"time="+time+"userId"+userId+"}";
    }
}
