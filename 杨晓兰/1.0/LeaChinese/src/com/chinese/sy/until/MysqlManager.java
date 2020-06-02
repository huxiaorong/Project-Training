package com.chinese.sy.until;

import java.sql.*;

public class MysqlManager {
	private static  Connection mConnect;
	// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
	// static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	// static final String DB_URL = "jdbc:mysql://localhost:3306/readbook?characterEncoding=UTF-8";
	//MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost:3306/daystu?useSSL=false&serverTimezone=UTC";
	// 数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "rootroot";
    static {
        try { 
        	 // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            mConnect=DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return mConnect;
        
    }
    public static void  close() {
        try {
            mConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
