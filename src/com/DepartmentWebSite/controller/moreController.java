package com.DepartmentWebSite.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DepartmentWebSite.model.morenewsModel;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;
import com.DepartmentWebSite.service.IGetAllNews;
import com.DepartmentWebSite.service.IGetCurrentNews;
import com.DepartmentWebSite.service.impl.IGetAllNewsImpl;
import com.DepartmentWebSite.service.impl.IGetCurrentNewsImpl;

@Controller
@RequestMapping("/more")

public class moreController {
	
	private IGetAllNews igetallnews;
	
	
	
	 public moreController() {
		this.igetallnews=new IGetAllNewsImpl();
	}
	
	
	
	@RequestMapping("/{section}")
	public String index(Model model,@PathVariable("section") String section) throws SQLException
	{
		String str="";		
		
		switch(section)
		{
			case "zytz":
			{
				str="重要通知";
				break;
			}
			case "zlxx":
			{
				str="质量信息";
				break;
			}
			case "bmdt":
			{
				str="部门动态";
				break;
			}
			case "ryb":
			{
				str="荣誉榜";
				break;
			}
			case "bcjs":
			{
				str="靶场纪实";
				break;
			}
			case "qyzx":
			{
				str="前沿资讯";
				break;
			}
			case "zsk":
			{
				str="知识库";
				break;
			}
			case "sjgf":
			{
				str="设计规范";
				break;
			}
			case "gzzd":
			{
				str="规章制度";
				break;
			}
			default:
				str="";
		}
		
		
		//id
		newsModel[] news= this.igetallnews.GetIndexPageNews(str);
		
		if(news!=null)
		{
			morenewsModel[] morenews=new morenewsModel[news.length];
			
			for(int i=0;i<news.length;i++)
			{
				morenews[i]=new morenewsModel();
				
				morenews[i].setNewsID(news[i].getNewsID());
				morenews[i].setTitle(news[i].getTitle()+"&nbsp&nbsp&nbsp&nbsp"+news[i].getReleaseDate());
			}
			
			
			
			model.addAttribute("listname", news);
		}
		
		
		model.addAttribute("title",str);
		
		
		return "more";
	}
}
