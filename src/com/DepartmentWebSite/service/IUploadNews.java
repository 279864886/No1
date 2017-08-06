package com.DepartmentWebSite.service;

import java.sql.*;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;

public interface IUploadNews {
	boolean uploadNews(newsModel news);
	
	boolean uploadPhotos(photoModel photo);
}
