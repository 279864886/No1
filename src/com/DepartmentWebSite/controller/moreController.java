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
                str = "��Ҫ֪ͨ";
                break;
            }
            case "quality": {
                str = "������̬";
                break;
            }
            case "culture": {
                str = "�����Ļ�";
                break;
            }
            case "honor": {
                str = "������";
                break;
            }
            case "report": {
                str = "�ⳡ��ʵ";
                break;
            }
            case "product": {
                str = "��Ʒ���";
                break;
            }
            case "zsk": {
                str = "֪ʶ��";
                break;
            }
            case "standard": {
                str = "��׼�淶";
                break;
            }
            case "rules": {
                str = "�����ƶ�";
                break;
            }
            case "knowledge": {
                str = "֪ʶ�����";
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
