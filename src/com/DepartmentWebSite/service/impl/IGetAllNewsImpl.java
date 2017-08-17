package com.DepartmentWebSite.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.rollingNewsModel;
import com.DepartmentWebSite.service.IGetAllNews;

public class IGetAllNewsImpl implements IGetAllNews {

	private IMySqlImpl imysql;
	private String PhotoID;
	
	public IGetAllNewsImpl()
	{
		this.imysql=new IMySqlImpl();
		
		this.imysql.setUrl("jdbc:mysql://localhost/department?characterEncoding=UTF-8");
		this.imysql.setUsername("chenwenhao");
		this.imysql.setPassword("cwh@222222");
	}
	
	
	//主页获取某版块的全部新闻
	@Override
	public newsModel[] GetIndexPageNews(String section) throws SQLException
	{
		// TODO Auto-generated method stub
		
		this.imysql.connSQL();
		
		String str="select * from news where newsSection='" + section+ "' order by releaseDate desc";
		
		ResultSet rs = this.imysql.selectSQL(str);
		
		int rowCount=0;
		try
		{
			rs.last();
			rowCount = rs.getRow();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		
		newsModel[] nm;
		
		if(rowCount>0)
			nm=new newsModel[rowCount];		
		else
			return null;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(nm!=null)
		{
			rs.beforeFirst();
			
			/**/
			for(int i=0;i<nm.length;i++)
			{
				rs.next();
			
				nm[i]=new newsModel();
				
				nm[i].setNewsID(rs.getString("newsID"));
				nm[i].setTitle(rs.getString("newsTitle"));
				nm[i].setSection(rs.getString("newsSection"));
				nm[i].setReleaseDate(rs.getDate("releaseDate"));
				nm[i].setReleasePerson(rs.getString("releasePerson"));			
				nm[i].setText(rs.getString("newsText"));			
			}
		}
		this.imysql.deconnSQL();
		
		return nm;
		
	}

	//主页获取某版块的全部新闻（最新的limit条）
	@Override
	public newsModel[] GetIndexPageNews(String section, int limit) throws SQLException {
		// TODO Auto-generated method stub
		this.imysql.connSQL();
		
		String str="select * from news where newsSection='" + section+ "' order by releaseDate desc limit "+Integer.toString(limit)+";";
		
		ResultSet rs = this.imysql.selectSQL(str);
		
		int rowCount=0;
		try
		{
			rs.last();
			rowCount = rs.getRow();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
		
		newsModel[] nm;
		
		if(rowCount>0)
			nm=new newsModel[rowCount];		
		else
			return null;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		if(nm!=null)
		{
			rs.beforeFirst();
			
			/**/
			for(int i=0;i<nm.length;i++)
			{
				rs.next();
			
				nm[i]=new newsModel();
			
				nm[i].setNewsID(rs.getString("newsID"));
				nm[i].setTitle(rs.getString("newsTitle"));
				nm[i].setSection(rs.getString("newsSection"));
				nm[i].setReleaseDate(rs.getDate("releaseDate"));
				nm[i].setReleasePerson(rs.getString("releasePerson"));			
				nm[i].setText(rs.getString("newsText"));				
			}
		}
		this.imysql.deconnSQL();
		
		return nm;
	}

	//主页获取滚动新闻
	@Override
	public rollingNewsModel[] GetIndexPageRollingNews(int limit) throws SQLException {
		// TODO Auto-generated method stub
		this.imysql.connSQL();
				
		String str="select news.newsTitle,news.newsID,photo.photoName from news,photo "
				 + "where news.newsID=photo.newsID "
				 + "order by photo.ID desc limit "+Integer.toString(limit)+";";
		
		ResultSet rs = this.imysql.selectSQL(str);
		
		int rowCount=0;
		try
		{
			rs.last();
			rowCount = rs.getRow();
		}
		catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
		
		rollingNewsModel[] nm;
		
		if(rowCount>0)
			nm=new rollingNewsModel[rowCount];		
		else
			return null;
		
		
		if(nm!=null)
		{
			rs.beforeFirst();
			
			/**/
			for(int i=0;i<nm.length;i++)
			{
				rs.next();
			
				nm[i]=new rollingNewsModel();
			
				nm[i].setNewsID(rs.getString("newsID"));
				nm[i].setTitle(rs.getString("newsTitle"));
				nm[i].setPhotoID(rs.getString("photoName"));
			}
		}
		this.imysql.deconnSQL();
		
		return nm;
		
		
	}
	
	
	
	
}
