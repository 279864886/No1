package com.DepartmentWebSite.service;

import java.sql.SQLException;

import com.DepartmentWebSite.model.newsModel;

public interface IGetZYTZ {
	
	
	newsModel[] GetIndexPageNews(String section) throws SQLException;

}
