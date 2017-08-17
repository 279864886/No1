package com.DepartmentWebSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = {"", "/about"})
public class aboutController {


    @RequestMapping()
    public String index() {
        return "about";
    }

}


