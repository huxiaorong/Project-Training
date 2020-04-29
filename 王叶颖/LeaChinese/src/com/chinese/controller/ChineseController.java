package com.chinese.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinese.dao.ChineseDao;
import com.chinese.entity.Question_Tingyinshizi;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ChineseController {
	
	
	@Resource
	ChineseDao chineseDao;
	
	@RequestMapping("/getTime")
	public void selectTime(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException {
		String userId = request.getParameter("userId");
		System.out.println("////");
		int id = Integer.parseInt(userId);
		System.out.println(id);
		List<Integer> list = chineseDao.selectTime(id);
		PrintWriter writer = response.getWriter();
		JSONObject object = new JSONObject();
		object.put("goalTime", list.get(0));
		object.put("reviewedTime", list.get(1));
		writer.println(object.toString());
		writer.flush();
		writer.close();
		System.out.println(list.get(0)+"/"+list.get(1));
	}
	
	@RequestMapping("/tingyinshizi")
	public void tingyinxuanzi(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		int id = Integer.parseInt(userId);
		List<Integer> list = chineseDao.selectWrongWord(id);
		List<Question_Tingyinshizi> qlist = chineseDao.questionTing(list);

		Gson gson = new Gson();
		String str = gson.toJson(qlist);
		
		PrintWriter writer = response.getWriter();
		writer.println(str);
		writer.flush();
		writer.close();
		
		System.out.println(str);
	}
	

}
