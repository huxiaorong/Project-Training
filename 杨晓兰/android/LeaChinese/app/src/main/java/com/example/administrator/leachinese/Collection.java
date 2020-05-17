package com.example.administrator.leachinese;

public class Collection {
    private int id;
    private int userId;
    private int wordId;

    public Collection(){}
    public Collection(int id,int userId,int wordId){
        this.id = id;
        this.userId = userId;
        this.wordId = wordId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", userId=" + userId +'\'' +
                ", wordId='" + wordId +
                '}';
    }
}
