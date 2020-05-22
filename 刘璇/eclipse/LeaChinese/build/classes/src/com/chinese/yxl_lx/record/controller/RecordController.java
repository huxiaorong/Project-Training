package com.chinese.yxl_lx.record.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinese.entity.Record;
import com.chinese.yxl_lx.record.service.RecordServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/record")
public class RecordController {
	@Resource
	private RecordServiceImpl recordServiceImpl;
	
	@ResponseBody
	@RequestMapping("/add")
	public String addRecord(@RequestParam(value = "userId",defaultValue="1") int userId) {
		System.out.println("请求添加学习时间");
		Record record = new Record();
		record.setStudiedTime(new Date());
		record.setUserId(userId);
		this.recordServiceImpl.addCalendar(record);
		System.out.println("返回参数");
		System.out.println("add calender OK");
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/find/today")
	public String findToday(@RequestParam(value = "userId",defaultValue="1") int userId) {
		System.out.println("请求查询今天记录");
		Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();		
		System.out.println("返回参数");
		System.out.println(gson.toJson(this.recordServiceImpl.findToday(userId)));
		return gson.toJson(this.recordServiceImpl.findToday(userId));
	}
	
	@ResponseBody
	@RequestMapping("/find/thisWeek")
	public String findThisWeek(@RequestParam(value = "userId",defaultValue="1") int userId) {
		System.out.println("请求获取本周数据");
		Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();		
		System.out.println("返回参数");
		System.out.println("thisWeek："+gson.toJson(this.recordServiceImpl.findThisWeek(userId)));
		return gson.toJson(this.recordServiceImpl.findThisWeek(userId));
	}
	
	@ResponseBody
	@RequestMapping("/find/thisMonth")
	public String findThisMonth(@RequestParam(value = "userId",defaultValue="1") int userId) {
		System.out.println("请求获取本月数据");
		List<Record> records = this.recordServiceImpl.findThisMonth(userId);
		int[] month = new int[31];
		for(int i=0;i<31;i++) {
			month[i] = 0;
		}
		for(Record record : records) {
			month[Integer.parseInt(new SimpleDateFormat("dd").format(record.getStudiedTime()))-1]=1;
		}
		Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();		
		System.out.println("返回参数");
		for(int i=0;i<31;i++) {
			System.out.println(month[i] );
		}
		return gson.toJson(month);
	}
}
