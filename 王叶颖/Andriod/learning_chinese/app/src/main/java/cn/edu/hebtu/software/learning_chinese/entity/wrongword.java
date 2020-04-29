package cn.edu.hebtu.software.learning_chinese.entity;

import java.util.Date;

public class wrongword {

    private int id;
    private int wordId;
    private Date time;
    private int userId;

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
}
