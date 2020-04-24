package com.chinese.yxl_lx.record.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chinese.entity.Record;
import com.chinese.yxl_lx.util.BaseDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Repository
public class RecordDaoImpl extends BaseDao<Record, Integer> {
	public void saveCalendar(Record calendar) {
		try {
			super.save(calendar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Record> findToday(int userId) {
		Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
		
		try {
			return gson.fromJson(
					gson.toJson(super.findBySql("select * from record where to_days(studiedTime)=to_days(now()) and userId=?", 
							new Object[] {userId})),
					new TypeToken<List<Record>>() {
			        }.getType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
