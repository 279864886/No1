package com.DepartmentWebSite.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DepartmentWebSite.model.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public interface IMySql {

	void connSQL();	
	
	void deconnSQL();	
	
	ResultSet selectSQL(String sql);
	
	boolean insertSQL(String sql);
	
	boolean deleteSQL(String sql);
	
	boolean updateSQL(String sql);
	
	
	
}
