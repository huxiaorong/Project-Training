package com.chinese.weixinxin.findgame.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinese.entity.Word;
import com.chinese.weixinxin.findgame.service.WordServicew;
import com.google.gson.Gson;

@Controller
@RequestMapping("/word")
public class WordControllerw {
	@Resource
	private WordServicew wordService;

	@RequestMapping("/findLikeWord")
	@ResponseBody
	public String findLikeWord(@RequestParam("findlevel") int findLevel) {
		System.out.println("建立连接" + findLevel);

		Word word = wordService.findLikeWord(findLevel);

		if (word != null) {
			System.out.println(word.toString());
			// session.setAttribute("user",user);
			Gson gson = new Gson();
			String wString = gson.toJson(word);
			return wString;
		} else {
			return "{\"r\":\"fail\"}";
		}
	}
}
