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
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news")
public class newsController {

    private IGetCurrentNews igetcurrnews;

    public newsController() {
        this.igetcurrnews = new IGetCurrentNewsImpl();
    }

//    @RequestMapping()
//    public String index()
//    {
//        return "news";
//    }


    @RequestMapping("/id/{id}")
    public String index(@PathVariable("id") String id,Model model) throws SQLException {
        //id
        newsModel news = this.igetcurrnews.GetCurrentNews(id);

        if (news != null) {
            model.addAttribute("currentnews", news);

            photoModel photo = this.igetcurrnews.GetCurrentNewsPhoto(id);

            if(photo!=null)
            {
                model.addAttribute("currentphoto", photo);
            }
        }


        return "news";
    }

}
