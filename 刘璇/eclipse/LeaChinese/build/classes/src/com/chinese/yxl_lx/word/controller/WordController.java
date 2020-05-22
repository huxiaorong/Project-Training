package com.chinese.yxl_lx.word.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinese.entity.User;
import com.chinese.entity.Word;
import com.chinese.entity.WrongWord;
import com.chinese.yxl_lx.user.service.UserServiceImpl;
import com.chinese.yxl_lx.util.Constant;
import com.chinese.yxl_lx.util.Page;
import com.chinese.yxl_lx.word.service.WordServiceImpl;
import com.google.gson.Gson;



@Controller
@RequestMapping("/word")
public class WordController {
	@Resource
	private WordServiceImpl wordServiceImpl;
	
	@Resource
	private UserServiceImpl userServiceImpl;
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
			@RequestParam(value = "tag",defaultValue = "1") int tag) {
		System.out.println("请求获取今日单词列表");
		Page<Word> page = this.wordServiceImpl.listWords(pageNum,Constant.PAGE_SIZE,tag);
		Gson gson = new Gson();
		System.out.println("返回参数");
		System.out.println(gson.toJson(page.getList()));
		return gson.toJson(page.getList());
	}
	
	@ResponseBody
	@RequestMapping("/add/wrong")
	public String addWrongWord(@RequestParam(value = "userId",defaultValue = "1") int userId,
			@RequestParam(value = "wordId",defaultValue = "1") int wordId) {
		System.out.println("请求向错题本添加生词");
		WrongWord wrongWord = new WrongWord();
		wrongWord.setTime(new Date());
		wrongWord.setUserId(userId);
		wrongWord.setWordId(wordId);
		this.wordServiceImpl.addWrongWord(wrongWord);
		System.out.println("返回参数");
		System.out.println("add WrongWord OK");
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/count/tag")
	public String countWordsByTag(@RequestParam(value = "tag",defaultValue = "0") int tag) {
		System.out.println("请求按Tag查询单词数量");		
		System.out.println("返回参数");
		System.out.println(this.wordServiceImpl.countWordsByTag(tag));
		return this.wordServiceImpl.countWordsByTag(tag)+"";
	}
	
	@ResponseBody
	@RequestMapping("/find/learned")
	public String findLearned(@RequestParam(value = "userId",defaultValue = "1") int userId) {
		System.out.println("请求查询已学生词");		
		Gson gson = new Gson();
		User user = this.userServiceImpl.getUser(userId);
		List<Word> words = this.wordServiceImpl.findLearnedWords(user);
		System.out.println("返回参数");
		System.out.println(gson.toJson(words));
		return gson.toJson(words);
	}
	
	@ResponseBody
	@RequestMapping("/find/notLearned")
	public String findNotLearned(@RequestParam(value = "userId",defaultValue = "1") int userId) {
		System.out.println("请求查询未学生词");		
		Gson gson = new Gson();
		User user = this.userServiceImpl.getUser(userId);
		List<Word> words = this.wordServiceImpl.findNotLearnedWords(user);
		System.out.println("返回参数");
		System.out.println(gson.toJson(words));
		return gson.toJson(words);
	}
}
