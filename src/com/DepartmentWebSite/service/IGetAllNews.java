package com.DepartmentWebSite.service;

import java.sql.SQLException;

import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.rollingNewsModel;

public interface IGetAllNews {
	newsModel[] GetIndexPageNews(String section) throws SQLException;
	
	newsModel[] GetIndexPageNews(String section,int limit) throws SQLException;
	
	rollingNewsModel[] GetIndexPageRollingNews(int limit) throws SQLException;
	
	
}
