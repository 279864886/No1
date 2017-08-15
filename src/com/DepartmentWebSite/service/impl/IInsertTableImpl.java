package com.DepartmentWebSite.service.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.DepartmentWebSite.model.MeetingsDataEntity;
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
	public boolean InsertTable(photoModel photo) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into photo (newsID,photoName) "
				+"values ('"+photo.getNewsID()+"', '"+photo.getPhotoName()+"');";
		
		boolean re=false;
		
		this.imysql.connSQL();
		
		re=this.imysql.insertSQL(sql);
		
		this.imysql.deconnSQL();		
		
		return re;
	}

	@Override
	public boolean InsertTalbe(accessoryModel accessory) throws SQLException{
		// TODO Auto-generated method stub
		String sql="insert into accessory (newsID,fileName) "
				+"values ('"+accessory.getNewsID()+"', '"+accessory.getAccessoryName()+"');";
		
		boolean re=false;
		
		this.imysql.connSQL();
		
		re=this.imysql.insertSQL(sql);
		
		this.imysql.deconnSQL();		
		
		return re;
	}

	@Override
	public boolean InsertTable(MeetingsDataEntity meetings) throws SQLException {
		String sql="insert into meetings (start_date,end_date,content,locate,sponsor,agent,participant,remarks) "
				+"values (?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt;

		try {

			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/department?characterEncoding=UTF-8", "chenwenhao", "cwh@222222");

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setTimestamp(1,meetings.getMeetingStartDate());
			pstmt.setTimestamp(2, meetings.getMeetingEndDate());
			pstmt.setString(3, meetings.getMeetingContent());
			pstmt.setString(4, meetings.getMeetingLocate());
			pstmt.setString(5, meetings.getMeetingSponsor());
			pstmt.setString(6,meetings.getMeetingAgent());
			pstmt.setString(7,meetings.getMeetingParticipant());
			pstmt.setString(8,meetings.getMeetingRemarks());

			int i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}
