package com.DepartmentWebSite.service;

import com.DepartmentWebSite.model.accessoryModel;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;

public interface IInsertTalbe {
	boolean InsertTable(newsModel news);
	
	boolean InsertTable(photoModel photo);
	
	boolean InsertTalbe(accessoryModel accessory);
}
