package com.chinese.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	private int id;
    private String userName;
    private String password;
    private String tel;
    private String sex;
    private int studiedTag;
    private int numberTag;
    private int levelTag;
    private String img;
    private int levelone;
    private int leveltwo;
    private int levelthree;
    private int todaycount;

    
	public User(){}
   
	
    

	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getLevelTag() {
        return levelTag;
    }

    public void setLevelTag(int levelTag) {
        this.levelTag = levelTag;
    }
    public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	


	public int getLevelone() {
		return levelone;
	}




	public void setLevelone(int levelone) {
		this.levelone = levelone;
	}




	public int getLeveltwo() {
		return leveltwo;
	}




	public void setLeveltwo(int leveltwo) {
		this.leveltwo = leveltwo;
	}




	public int getLevelthree() {
		return levelthree;
	}




	public void setLevelthree(int levelthree) {
		this.levelthree = levelthree;
	}








	public String getPassword() {
		return password;
	}








	public void setPassword(String password) {
		this.password = password;
	}

	







	public int getTodaycount() {
		return todaycount;
	}








	public void setTodaycount(int toadycount) {
		this.todaycount = toadycount;
	}








	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", tel=" + tel + ", sex=" + sex
				+ ", studiedTag=" + studiedTag + ", numberTag=" + numberTag + ", levelTag=" + levelTag + ", img=" + img
				+ ", levelone=" + levelone + ", leveltwo=" + leveltwo + ", levelthree=" + levelthree + "]";
	}








	public User(int id, String userName, String password, String tel, String sex, int studiedTag, int numberTag,
			int levelTag, String img, int levelone, int leveltwo, int levelthree,int todaycount) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.tel = tel;
		this.sex = sex;
		this.studiedTag = studiedTag;
		this.numberTag = numberTag;
		this.levelTag = levelTag;
		this.img = img;
		this.levelone = levelone;
		this.leveltwo = leveltwo;
		this.levelthree = levelthree;
		this.todaycount = todaycount;
	}




	
	
    
}
