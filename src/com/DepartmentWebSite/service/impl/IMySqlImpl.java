package com.DepartmentWebSite.service.impl;

import com.DepartmentWebSite.service.IMySql;
import java.sql.*;
import com.DepartmentWebSite.model.newsModel;



public class IMySqlImpl implements IMySql {

	private Connection conn = null;  
	private PreparedStatement statement = null;     
    private String url;  
    private String username;  
    private String password;    
    
    
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public IMySqlImpl() {
		
//		Connection conn;
//		String url="jdbc:mysql://localhost:3306/mysql";    //JDBC的URL
		
		 this.url = "jdbc:mysql://localhost/hello?characterEncoding=UTF-8";  
		 this.username = "root";  
		 this.password = "root"; 
    }
	
	@Override
	public void connSQL() {
		try {   
            Class.forName("com.mysql.jdbc.Driver" );   
            conn = DriverManager.getConnection( url,this.username, this.password );   
            }  
        //捕获加载驱动程序异常  
         catch ( ClassNotFoundException cnfex ) {
        	 System.err.println("装载 JDBC/ODBC 驱动程序失败。");
             cnfex.printStackTrace();   
         }   
         //捕获连接数据库异常  
         catch ( SQLException sqlex ) { 
        	 System.err.println("无法连接数据库");
             sqlex.printStackTrace();   
         }  
		
	}

	@Override
	public void deconnSQL() {
		try {  
            if (conn != null)  
                conn.close();  
        } catch (Exception e) {  
            System.out.println("关闭数据库问题");  
            e.printStackTrace();  
        } 		
	}

	@Override
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;  
        try {  
            statement = conn.prepareStatement(sql);  
            rs = statement.executeQuery(sql);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rs;  
	}

	@Override
	public boolean insertSQL(String sql) {
		try {  
            statement = conn.prepareStatement(sql);  
            statement.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("插入数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("插入时出错：");  
            e.printStackTrace();  
        }  
        return false;  
	}

	@Override
	public boolean deleteSQL(String sql) {
		try {  
            statement = conn.prepareStatement(sql);  
            statement.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("插入数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("插入时出错：");  
            e.printStackTrace();  
        }  
        return false;
	}

	@Override
	public boolean updateSQL(String sql) {
		try {  
            statement = conn.prepareStatement(sql);  
            statement.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("插入数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("插入时出错：");  
            e.printStackTrace();  
        }  
        return false;  
	}

	
}
