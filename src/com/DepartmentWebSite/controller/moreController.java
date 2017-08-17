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
        this.igetallnews = new IGetAllNewsImpl();
    }


    @RequestMapping("/{section}")
    public String index(Model model, @PathVariable("section") String section) throws SQLException {
        String str;

        switch (section) {
            case "notification": {
                str = "重要通知";
                break;
            }
            case "quality": {
                str = "质量动态";
                break;
            }
            case "culture": {
                str = "部门文化";
                break;
            }
            case "honor": {
                str = "荣誉榜";
                break;
            }
            case "report": {
                str = "外场纪实";
                break;
            }
            case "product": {
                str = "产品简介";
                break;
            }
            case "zsk": {
                str = "知识库";
                break;
            }
            case "standard": {
                str = "标准规范";
                break;
            }
            case "rules": {
                str = "规章制度";
                break;
            }
            case "knowledge": {
                str = "知识库相关";
                break;
            }
            default:
                str = "";
        }


        //id
        newsModel[] news = this.igetallnews.GetIndexPageNews(section);

        if (news != null) {
            morenewsModel[] morenews = new morenewsModel[news.length];

            for (int i = 0; i < news.length; i++) {
                morenews[i] = new morenewsModel();

                morenews[i].setNewsID(news[i].getNewsID());
                morenews[i].setTitle(news[i].getTitle());
            }


            model.addAttribute("listname", news);
        }


        model.addAttribute("title", str);


        return "more";
    }
}
