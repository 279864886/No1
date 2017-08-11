package com.DepartmentWebSite.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meetingUpload")
public class meetingUploadController {


    @RequestMapping()
    public String upload(Model model) {
        return "meetingUpload";
    }
}
