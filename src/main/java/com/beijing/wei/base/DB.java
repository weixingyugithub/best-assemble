package com.beijing.wei.base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	public static Connection conn = null;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/root?useUnicode=true&characterEncoding=gbk";
			String usr = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url,usr,pwd);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}

	public static void colseConn(){
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void colsePreparedStatement(PreparedStatement ps){
		try{
			if(ps!=null && !ps.isClosed()){
				ps.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void colseResultSet(ResultSet rs){
		try{
			if(rs!=null && !rs.isClosed()){
				rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
