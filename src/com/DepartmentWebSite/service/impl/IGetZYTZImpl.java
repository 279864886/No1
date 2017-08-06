package com.DepartmentWebSite.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.service.IGetZYTZ;

public class IGetZYTZImpl implements IGetZYTZ {

	
	private IMySqlImpl imysql;
	
	public IGetZYTZImpl()
	{
		this.imysql=new IMySqlImpl();
		
		this.imysql.setUrl("jdbc:mysql://localhost/department?characterEncoding=UTF-8");
		this.imysql.setUsername("chenwenhao");
		this.imysql.setPassword("cwh@222222");
	}
	
	
	
	@Override
	public newsModel[] GetIndexPageNews(String section) throws SQLException
	{
		this.imysql.connSQL();
		
		ResultSet rs = this.imysql.selectSQL("select * from news order by ID desc");
		
		
		
		newsModel[] nm=new newsModel[5];
		
		/**/
		for(int i=0;i<nm.length;i++)
		{
			rs.next();
			
			nm[i]=new newsModel();
			
			nm[i].setNewsID(rs.getString("newsID"));
			nm[i].setTitle(rs.getString("title"));
			nm[i].setSection(rs.getString("section"));
			//nm[i].setReleaseDate(rs.getString("releaseDate"));
			nm[i].setReleasePerson(rs.getString("releasePerson"));
			
			nm[i].setText(rs.getString("newsText"));
			
		}
		
		this.imysql.deconnSQL();
		
		return nm;
	}

}
