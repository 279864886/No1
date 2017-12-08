package com.DepartmentWebSite.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.DepartmentWebSite.model.*;
import com.DepartmentWebSite.service.*;
import com.DepartmentWebSite.service.impl.IGetAllNewsImpl;
import com.DepartmentWebSite.service.impl.IGetZYTZImpl;
import com.DepartmentWebSite.service.impl.IMySqlImpl;

import java.sql.*;

@Controller
@RequestMapping(value = {"", "/index"})
public class indexController {

    //111

    private IGetZYTZ igetzytz;
    private IGetAllNews igetallnews;

    public indexController() {
        this.igetzytz = new IGetZYTZImpl();
        this.igetallnews = new IGetAllNewsImpl();
    }


    @RequestMapping()
    public String index(Model model) throws SQLException {


        rollingNewsModel[] roll = this.igetallnews.GetIndexPageRollingNews(5);
        newsModel[] zytz = this.igetallnews.GetIndexPageNews("notification", 5);
        newsModel[] zlxx = this.igetallnews.GetIndexPageNews("quality", 5);
        newsModel[] bmwh = this.igetallnews.GetIndexPageNews("culture", 5);
        newsModel[] ryb = this.igetallnews.GetIndexPageNews("honor", 5);
        newsModel[] bcjs = this.igetallnews.GetIndexPageNews("report", 5);
        newsModel[] cpjj = this.igetallnews.GetIndexPageNews("product", 5);

        //
        if (roll != null) {
            for (int i = 0; i < roll.length; i++)
                model.addAttribute("roll" + (i + 1), roll[i]);
        }

        if (zytz != null) {
            for (int i = 0; i < zytz.length; i++)
                model.addAttribute("zytz" + (i + 1), zytz[i]);
        }

        if (zlxx != null) {
            for (int i = 0; i < zlxx.length; i++)
                model.addAttribute("zlxx" + (i + 1), zlxx[i]);
        }

        if (bmwh != null) {
            for (int i = 0; i < bmwh.length; i++)
                model.addAttribute("bmdt" + (i + 1), bmwh[i]);
        }

        if (ryb != null) {
            for (int i = 0; i < ryb.length; i++)
                model.addAttribute("ryb" + (i + 1), ryb[i]);
        }

        if (bcjs != null) {
            for (int i = 0; i < bcjs.length; i++)
                model.addAttribute("bcjs" + (i + 1), bcjs[i]);
        }

        if (cpjj != null) {
            for (int i = 0; i < cpjj.length; i++)
                model.addAttribute("qyzx" + (i + 1), cpjj[i]);
        }

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();


        String str = request.getRealPath("/");


        return "index";
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public String news(@PathVariable String id) {

        return "";

    }

//  @RequestMapping("/test")
//  public String juansb(Model model)
//  {
//	  Maye mayulin=new Maye();
//	  
//	  mayulin.setPath("111");
//	  mayulin.setTitle("222");
//	  
//		  model.addAttribute("mayulin", mayulin);
//	  
//	  return "index";
//	  
//  }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String getMsg(@PathVariable Integer id) {
        if (id == 1) {
            return "hello world";
        } else {
            return "juan";
        }

    }
}
