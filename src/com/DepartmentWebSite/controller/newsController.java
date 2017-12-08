package com.DepartmentWebSite.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;
import com.DepartmentWebSite.service.IGetCurrentNews;
import com.DepartmentWebSite.service.IGetZYTZ;
import com.DepartmentWebSite.service.impl.IGetCurrentNewsImpl;
import com.DepartmentWebSite.service.impl.IGetZYTZImpl;

@Controller
@RequestMapping("/news")
public class newsController {
	
	private IGetCurrentNews igetcurrnews;
	
	 public newsController() {
		this.igetcurrnews=new IGetCurrentNewsImpl();
	}
	
	
	@RequestMapping("/{id}")
	public String index(Model model,@PathVariable("id") String id) throws SQLException
	{
		//id
		newsModel news= this.igetcurrnews.GetCurrentNews(id);
		
		if(news!=null)
		{
			model.addAttribute("currentnews", news);
			
			photoModel photo=this.igetcurrnews.GetCurrentNewsPhoto(id);
			
			//if(photo!=null)
			{
				model.addAttribute("currentphoto", photo);
			}
		}
		
		
		
		return "news";
	}

}
