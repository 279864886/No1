package com.DepartmentWebSite.service;

import java.sql.SQLException;

import com.DepartmentWebSite.model.accessoryModel;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;

public interface IGetCurrentNews {

	newsModel GetCurrentNews(String newsID) throws SQLException;
	
	photoModel GetCurrentNewsPhoto(String newsID) throws SQLException;

	accessoryModel GetCurrentNewsAccessory(String newsID) throws SQLException;
}
