package com.example.administrator.leachinese;

public class User {
    private int id;
    private String userName;
    private String tel;
    private String sex;
    private int studiedTag;
    private int numberTag;

    public User(){}
    public User(int id,String userName,String tel,String sex,int studiedTag,int numberTag){
        this.id = id;
        this.userName = userName;
        this.tel = tel;
        this.sex = sex;
        this.studiedTag = studiedTag;
        this.numberTag = numberTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    @Override
    public String toString() {
        return "User{"+"id="+id+"userName"+userName+"tel="+tel+"sex="+sex+"studiedTag="+studiedTag+"numberTag="+numberTag+"}";
    }
}
