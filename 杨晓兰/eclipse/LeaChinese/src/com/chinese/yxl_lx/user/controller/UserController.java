package com.chinese.yxl_lx.user.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinese.entity.Collection;
import com.chinese.entity.User;
import com.chinese.entity.UserProgress;
import com.chinese.yxl_lx.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userServiceImpl;
	
	@ResponseBody
	@RequestMapping("/update/num")
	public String updateUser(@RequestParam(value = "userId",defaultValue="1") int userId) {
		System.out.println("请求更新用户表");
		User user = this.userServiceImpl.getUser(userId);
		user.setNumberTag(user.getNumberTag()+1);
		this.userServiceImpl.updateUser(user);
		UserProgress userProgress = this.userServiceImpl.getProgress(user);
		userProgress.setNumberTag(user.getNumberTag());
		this.userServiceImpl.updateUserProgress(userProgress);
		System.out.println("返回参数");
		System.out.println("update OK");
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/add/collection")
	public String addCollection(@RequestParam(value = "userId",defaultValue="1") int userId,
			@RequestParam(value = "wordId",defaultValue = "1") int wordId) {
		System.out.println("请求添加收藏");
		Collection collection = new Collection();
		collection.setUserId(userId);
		collection.setWordId(wordId);
		this.userServiceImpl.addCollection(collection);
		System.out.println("返回参数");
		System.out.println("add collection OK");
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/update/progress")
	public String updateProgress(@RequestParam(value = "userId",defaultValue="1") int userId,
			@RequestParam(value = "studiedTag",defaultValue="1") int studiedTag,
			@RequestParam(value = "numberTag",defaultValue="0") int numberTag) {
		System.out.println("请求更新用户进度");
		User user = this.userServiceImpl.getUser(userId);
		user.setNumberTag(numberTag);
		user.setStudiedTag(studiedTag);
		this.userServiceImpl.updateUser(user);
		UserProgress userProgress = this.userServiceImpl.getProgress(user);
		userProgress.setNumberTag(numberTag);
		userProgress.setStudiedTag(studiedTag);
		this.userServiceImpl.updateUserProgress(userProgress);
		System.out.println("返回参数");
		System.out.println("update progress OK");
		return "OK";
	}
	
	
}
