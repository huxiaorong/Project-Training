package com.chinese.sy.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinese.sy.controller.SelTis;
import com.chinese.sy.until.MysqlManager;
import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Servlet implementation class TiServlet
 */
@WebServlet("/TiServlet")
public class TiServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//连接数据库
		Connection mConnect = MysqlManager.getConnection();
	    Statement stmt = null;
	    // 要执行的SQL语句
	    String sql="select * from seltis";
	    try {
			  // 执行查询
	          stmt = mConnect.createStatement();
	          ResultSet rs = stmt.executeQuery(sql);
	          List<SelTis> list=new ArrayList<SelTis>();
	          while(rs.next()) {
	        	  SelTis ti=new SelTis();
	        	  ti.setId(rs.getInt("id"));
	        	  ti.setAnswer(rs.getInt("answer"));
	        	  ti.setSel1(rs.getString("sel1"));
	        	  ti.setSel2(rs.getString("sel2"));
	        	  ti.setSel3(rs.getString("sel3"));
	        	  ti.setSel4(rs.getString("sel4"));
	        	  ti.setTitle(rs.getString("title"));
	        	  list.add(ti);
	          }
	          // 完成后关闭
	          rs.close();
	          stmt.close();
	          //生成json字符串
	          Gson gson=new Gson();
	          HashMap map=new HashMap();
	          if(list.size()!=0) {
	        	  map.put("code", 200);
		          map.put("message","查询成功");
		          map.put("data", list);
	          }else {
	        	  map.put("code", 400);
	        	  map.put("message","暂无复习内容");
		          map.put("data",new ArrayList<SelTis>());
	          }
	          String json=gson.toJson(map);
	           
	          //返回给app
	          response.setContentType("text/plain");
	          response.setCharacterEncoding("utf-8");
	          PrintWriter out = new PrintWriter(response.getOutputStream());
	          out.print(json);
	          out.flush();
	    }
	    catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
