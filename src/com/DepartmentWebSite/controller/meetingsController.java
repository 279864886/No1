package com.DepartmentWebSite.controller;


import com.DepartmentWebSite.model.MeetingsDataEntity;
import com.DepartmentWebSite.service.IGetAllMeetings;
import com.DepartmentWebSite.service.impl.IGetAllMeetingsImpl;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
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
    public String index(Model model) throws SQLException, IOException {

        MeetingsDataEntity[] meetings = iGetAllMeetings.GetAllMeetings();

        if (meetings != null) {

            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            String date = "(" + sdf.format(meetings[0].getMeetingStartDate()) + "--"
                    + sdf.format(meetings[meetings.length - 1].getMeetingStartDate()) + ")";

            model.addAttribute("meetings", meetings);
            model.addAttribute("date", date);
        }
        return "meetings";
    }

}
