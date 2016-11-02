package com.beijing.wei.base;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class Dao {

		
	/**
	 * 
	 * @param sql
	 * @return
	 * 作者：xingyu wei
	 * 作用：用于查询语句，反回一个ResultSet集合
	 */
	
	
	public String selectData(String sql,String pass){
		String s = "0";
		ResultSet rs  = null;
		try{
			Connection conn =DB.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(!pass.equals(rs.getString("password"))){
					s = "1";
				}else{
					s = "2";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
			return s;
		
	}
	
	
	/**
	 * 
	 * 作用：用于插入，修改，删除  返回一个整型
	 * @param sql
	 * @return
	 */
	
	
	public int update(String sql){
		int x = 0;
		try{
			Connection conn =DB.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			x= ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return x;
	}
	
	/**
	 * 
	 * @param sql反回一个List用于select查询
	 * @param cla
	 * @return
	 */
	
	public List getList(String sql,Class cla){
		List list  =  new ArrayList();
		try{
			Connection conn = DB.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = this.getListTo(rs, cla);
			rs.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List getListTo(ResultSet rs,Class cla){
		List list  = new ArrayList();
		try{
			//找到sql里的所有列
			ResultSetMetaData rsmd = rs.getMetaData();
			int column  = rsmd.getColumnCount();
			//放到一个map里面
			Map map1 =  new HashMap();
			for(int i=1;i<=column;i++){
				map1.put(rsmd.getColumnName(i).toUpperCase(), "");	
			}
	
			//取出实体中的所有方法
			Method[] method = cla.getDeclaredMethods();

			Map map2 = new HashMap();
			for(int i=0; i < method.length; i++){
				map2.put(method[i].getName().toUpperCase(), method[i]);              //把实体中的所有方法放到一个map中
			}
			
			//反射数据
			while(rs.next()){
				Object obj = cla.newInstance();
				Iterator it = map1.keySet().iterator();
				while(it.hasNext()){
					String sqlColumn = (String)it.next();              //获取sql列名
					Method m = (Method)map2.get("SET"+sqlColumn);      //实体方法
					if(m == null){
						continue;
					}
					m.invoke(obj, rs.getObject(sqlColumn));
				}
				list.add(obj);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	


	
	public List show(){                        //显示所有用户
//		List<Users> l = new ArrayList();
//		try{
//			Connection conn = DB.getConn();
//			String sql = "select * from users";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			Users user1 = new Users();
//			while(rs.next()){
//				 user1 = new Users(rs.getString("name"),rs.getString("pass"));
//				l.add(user1);
//			}
//			rs.close();
//			ps.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return l;
		return null;
	}
}
