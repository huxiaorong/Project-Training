package com.example.administrator.leachinese;

public class UserProgress {
    private int id;
    private int userId;
    private int studiedTag;
    private int numberTag;
    private int levelTag;

    public UserProgress(){}
    public UserProgress(int id,int userId,int studiedTag,int numberTag,int levelTag){
        this.id = id;
        this.userId = userId;
        this.studiedTag = studiedTag;
        this.numberTag = numberTag;
        this.levelTag = levelTag;
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

    public int getStudiedTag() {
        return studiedTag;
    }

    public void setStudiedTag(int studiedTag) {
        this.studiedTag = studiedTag;
    }

    public int getNumberTag() {
        return numberTag;
    }

    public void setNumberTag(int numberTag) {
        this.numberTag = numberTag;
    }

    public int getLevelTag() {
        return levelTag;
    }

    public void setLevelTag(int levelTag) {
        this.levelTag = levelTag;
    }

    @Override
    public String toString() {
        return  "UserProgress{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", studiedTag='" + studiedTag + '\'' +
                ", numberTag='" + numberTag + '\'' +
                ", levelTag='" + levelTag +
                '}';
    }
}
