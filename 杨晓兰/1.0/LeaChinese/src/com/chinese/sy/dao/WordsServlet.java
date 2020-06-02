package com.chinese.sy.dao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import util.MysqlManager;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import bean.Words;
import com.google.gson.Gson;

/**
 * Servlet implementation class WordsServlet
 */
@WebServlet("/WordsServlet")
public class WordsServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String id=request.getParameter("id");
		//连接数据库
		Connection mConnect = MysqlManager.getConnection();
	    Statement stmt = null;
		// 要执行的SQL语句
	    String sql="select * from words where id="+id;
	    try {
			  // 执行查询
	          stmt = mConnect.createStatement();
	          ResultSet rs = stmt.executeQuery(sql);
	          List<Words> list = new ArrayList<Words>();
	          // 展开结果集数据库
	          while(rs.next()){
	        	  Words words = new Words();
	        	  words.setId(rs.getInt("id"));
	        	  words.setWords(rs.getString("words"));
	        	  list.add(words);
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
		          map.put("data",new ArrayList<Words>());
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
