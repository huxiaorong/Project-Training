package com.chinese.yxl_lx.record.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinese.entity.Record;
import com.chinese.yxl_lx.record.dao.RecordDaoImpl;

@Service
@Transactional(readOnly=false)
public class RecordServiceImpl {
	@Resource
	private RecordDaoImpl recordDaoImpl;
	
	public void addCalendar(Record calendar) {
		this.recordDaoImpl.saveCalendar(calendar);
	}
	
	public List<Record> findToday(int userId) {
		return this.recordDaoImpl.findToday(userId);
	}
	
	public List<Record> findThisWeek(int userId) {
		return this.recordDaoImpl.findThisWeek(userId);
	}
	
	public List<Record> findThisMonth(int userId) {
		return this.recordDaoImpl.findThisMonth(userId);
	}
}
