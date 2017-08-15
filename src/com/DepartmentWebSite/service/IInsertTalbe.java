package com.DepartmentWebSite.service;

import java.sql.SQLException;

import com.DepartmentWebSite.model.MeetingsDataEntity;
import com.DepartmentWebSite.model.accessoryModel;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;

public interface IInsertTalbe {
	boolean InsertTable(newsModel news);
	
	boolean InsertTable(photoModel photo) throws SQLException;
	
	boolean InsertTalbe(accessoryModel accessory) throws SQLException;

	boolean InsertTable(MeetingsDataEntity meetings) throws SQLException;
}
