package com.DepartmentWebSite.service.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.DepartmentWebSite.model.accessoryModel;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;
import com.DepartmentWebSite.service.IInsertTalbe;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class IInsertTableImpl implements IInsertTalbe {

	private IMySqlImpl imysql;
	
	public IInsertTableImpl()
	{
		this.imysql=new IMySqlImpl();
		
		this.imysql.setUrl("jdbc:mysql://localhost/department?characterEncoding=UTF-8");
		this.imysql.setUsername("chenwenhao");
		this.imysql.setPassword("cwh@222222");
	}
	
	@Override
	public boolean InsertTable(newsModel news) {
		// TODO Auto-generated method stub
		
		String sql="insert into news (newsID,newsTitle,newsSection,releasePerson,releaseDate,newsText) "
				+"values (?,?,?,?,?,?)";
		
		PreparedStatement pstmt;
		
		try {
			
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/department?characterEncoding=UTF-8", "chenwenhao", "cwh@222222");
			
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, news.getNewsID());
	        pstmt.setString(2, news.getTitle());
	        pstmt.setString(3, news.getSection());
	        pstmt.setString(4, news.getReleasePerson());
	        pstmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
	        pstmt.setString(6,news.getText());
	        int i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
		
		
		
	}

	@Override
	public boolean InsertTable(photoModel photo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean InsertTalbe(accessoryModel accessory) {
		// TODO Auto-generated method stub
		return false;
	}

}
