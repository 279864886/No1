package com.DepartmentWebSite.controller;


import com.DepartmentWebSite.model.MeetingsDataEntity;
import com.DepartmentWebSite.service.IGetAllMeetings;
import com.DepartmentWebSite.service.impl.IGetAllMeetingsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Controller
@RequestMapping(value = {"", "/meetings"})
public class meetingsController {

    private IGetAllMeetings iGetAllMeetings;

    public meetingsController() {
        iGetAllMeetings = new IGetAllMeetingsImpl();
    }

    @RequestMapping()
    public String index(Model model) throws SQLException {

        MeetingsDataEntity[] meetings =iGetAllMeetings.GetAllMeetings();


        if(meetings!=null)
            model.addAttribute("meetings", meetings);


        return "meetings";
    }

}
