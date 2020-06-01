package com.chinese.hxr.user.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinese.entity.Collection;
import com.chinese.entity.Word;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;




public class CenterController extends Controller {
	
	public void index(){
		System.out.println("mmmm");
	}
	
	public void register(){
		String phone = get("phone");
		String pwd = get("pwd");
		List<Record> phones = Db.find("select tel from user");
		int i = 0;
		for(;i<phones.size();++i){
			if(phones.get(i).equals(phone)){
				renderJson("您输入的手机号已被注册");
				break;
			}
		}
		if(i == phones.size()){
			Record user = new Record().set("tel", phone).set("password", pwd);
			Db.save("user", user);
			renderJson("注册成功");
		}
	}
	
	public void login(){
		String phone = get("phone");
		String pwd = get("pwd");
		Record user = Db.findFirst("select * from user where tel ='"+ phone + "' && password ='"+pwd+"'");
		if(null == user){
			renderJson("登录失败");
		}else{
			renderJson(user);
		}
		
	}


	public void edit(){
		String username = get("username");
		String sex = get("sex");
		
		String levelTag=get("levelTag");
		Record user = Db.findById("user", get("userId")).set("userName", username).set(levelTag, levelTag);
		Db.update("user", user);
			
		renderJson("修改成功");
		
	}
	public void numLogin(){
		String phone = get("phone");
		Record user = Db.findFirst("select * from user where tel ="+ phone);
		if(null == user){
			Record user1 = new Record().set("tel", phone);
			Db.save("user", user1);
			renderJson(user1);
		}else{
			renderJson(user);
		}
	}
	public void forget(){
		String phone = get("phone");
		String pwd = get("pwd");
		Record user = Db.findFirst("select * from user where tel ="+ phone);
		if(null == user){
			renderJson("手机号输入有误");
		}else{
			Record user1 = Db.findById("user", user.get("id")).set("password", pwd);
			Db.update("user", user1);
			renderJson(user1);
		}
	}
	public void modifyNum(){
		String phone = get("phone");
		String newPhone = get("newPhone");
		Record user2 = Db.findFirst("select * from user where tel ="+ newPhone);
		if(null == user2){
			Record user = Db.findFirst("select * from user where tel ="+ phone);
			Record user1 = Db.findById("user", user.get("id")).set("tel", newPhone);
			Db.update("user", user1);
			renderJson(user1);
		}else{
			renderJson("您输入的手机号已存在");
		}
	}
	public void changePwd(){
		String phone = get("phone");
		String pwd = get("pwd");
		String pwd1 = get("newPwd");
		Record user = Db.findFirst("select * from user where tel ='"+ phone + "' && password ='"+pwd+"'");
		Record user1 = Db.findById("user", user.get("id")).set("password", pwd1);
		Db.update("user", user1);
		renderJson("修改成功");
	}
	
	public void cancellation(){
		int userId = Integer.parseInt(getPara("userId"));
		Db.delete("delete from user where id = "+userId);
		renderJson("注销成功");
		
	}
	public void sendMessage(){
		String content = get("etContent");
		String email = get("etMail");
		int userId = Integer.parseInt(getPara("userId"));
		Record opinion = new Record().set("content", content).set("email", email).set("userId", userId).set("date", new Date());
		Db.save("opinion", opinion);
		renderJson("发送成功");
	}
	
	
	
	public void upload() throws IOException{
		UploadFile upfile = getFile();
		File file = upfile.getFile();
		String fileName = new SimpleDateFormat("yyyyMMddkkmmss").format(new Date())+".jpg";
		String path = "C:/Users/20177/Desktop/headPicture"+fileName;
		File saveFile = new File(path);
		upfile.getFile().renameTo(saveFile);
		String id = get("userId");
		Record user1 = Db.findById("user", id).set("headPicture", fileName);
		Db.update("user", user1);
		renderJson(fileName);
	}
	
	
	
	

	public void getCollection(){
		int userId = Integer.parseInt(getPara("userId"));
		List<Record> words = Db.find("select word* from collection,word where userId = "+userId+"&& word.id = collection.useId");
		System.out.println(words);
		renderJson(words);
	}
	public void getMistake(){
		int userId = Integer.parseInt(getPara("userId"));
		List<Record> words = Db.find("select word* from wrongword,word where userId = "+userId+"&& word.id = wrongword.useId");
		System.out.println(words);
		renderJson(words);
	}
	public void getCount(){
		int userId = Integer.parseInt(getPara("userId"));
		
		int totalDayCount = Db.queryInt("SELECT studiedTag FROM user where userId =" + userId);
		int totalstudyCount = Db.queryInt("select numberTag from user where userId =" + userId);
		setAttr("totalDayCount",totalDayCount);
		setAttr("totalstudyCount",totalstudyCount);
		renderJson(new String[]{"totalDayCount","totalstudyCount"});
	}
}
