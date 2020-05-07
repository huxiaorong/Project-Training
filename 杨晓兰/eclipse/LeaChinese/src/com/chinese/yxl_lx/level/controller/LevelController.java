package com.chinese.yxl_lx.level.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.chinese.entity.Level;
import com.chinese.yxl_lx.level.service.LevelServiceImpl;
import com.google.gson.Gson;

@Controller
@RequestMapping("/level")
public class LevelController {
	@Resource
	private LevelServiceImpl levelServiceImpl;
	
	@ResponseBody
	@RequestMapping("/list")
	public String List(){
		System.out.println("请求获取年级等级书目");
		List<Level> books = levelServiceImpl.findLevelbooks();
		Gson gson = new Gson();
		System.out.println("返回参数");
		System.out.println(gson.toJson(books));
		return gson.toJson(books);
	}
	
}
