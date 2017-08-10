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

//        OPCPackage opcPackage = POIXMLDocument.openPackage("d:\\2007.doc");
//        POIXMLTextExtractor extractor = null;
//        try {
//            extractor = new XWPFWordExtractor(opcPackage);
//
//        } catch (OpenXML4JException | XmlException e) {
//            e.printStackTrace();
//        }
//
//        if (extractor != null) {
//            String text2007 = extractor.getText();
//        }

        InputStream is = new FileInputStream(new File("d:\\2007.doc"));
        WordExtractor ex = new WordExtractor(is);

        FileInputStream in = new FileInputStream("D:\\2007.doc");//载入文档
        POIFSFileSystem pfs = new POIFSFileSystem(in);
        HWPFDocument hwpf = new HWPFDocument(pfs);
        Range range = hwpf.getRange();//得到文档的读取范围
        TableIterator it = new TableIterator(range);


        String text2003 = ex.getText();
        //String date=text2003

        ArrayList<MeetingsDataEntity> meetings = new ArrayList<>();


        String[] weekDays = {"\u661f\u671f\u65e5", "\u661f\u671f\u4e00", "\u661f\u671f\u4e8c",
                "\u661f\u671f\u4e09", "\u661f\u671f\u56db", "\u661f\u671f\u4e94", "\u661f\u671f\u516d"};

        //String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        while (it.hasNext()) {
            Table tb = (Table) it.next();
            //迭代行，默认从0开始
            for (int i = 1; i < tb.numRows(); i++) {
                TableRow tr = tb.getRow(i);
                MeetingsDataEntity temp = new MeetingsDataEntity();

                TableCell td = tr.getCell(0);
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    String s = para.text().replace('\n', ' ').replace('\r', ' ').trim();

                    temp.setMeetingStartDate(Timestamp.valueOf(s + ":00"));
                }

                td = tr.getCell(1);
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    String s = para.text().replace('\n', ' ').replace('\r', ' ').trim();

                    temp.setMeetingEndDate(Timestamp.valueOf(s + ":00"));
                }

                td = tr.getCell(2);
                String content = "";
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    content += para.text().replace('\n', ';').replace('\r', ';').trim();

                }
                temp.setMeetingContent(content);

                td = tr.getCell(3);
                String locate = "";
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    locate += para.text().replace('\n', ';').replace('\r', ';').trim();

                }
                temp.setMeetingLocate(locate);

                td = tr.getCell(4);
                String sponsor = "";
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    sponsor += para.text().replace('\n', ';').replace('\r', ';').trim();

                }
                temp.setMeetingSponsor(sponsor);

                td = tr.getCell(5);
                String agent = "";
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    agent += para.text().replace('\n', ';').replace('\r', ';').trim();

                }
                temp.setMeetingAgent(agent);


                td = tr.getCell(6);
                String participant = "";
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    participant += para.text().replace('\n', ';').replace('\r', ';').trim();

                }
                temp.setMeetingParticipant(participant);

                td = tr.getCell(7);
                String remarks = "";
                for (int k = 0; k < td.numParagraphs(); k++) {
                    Paragraph para = td.getParagraph(k);
                    remarks += para.text().replace('\n', ';').replace('\r', ';').trim();

                }
                temp.setMeetingRemarks(remarks);

                Calendar cal = new GregorianCalendar();
                cal.setTime(temp.getMeetingStartDate());
                int day = cal.get(Calendar.DAY_OF_WEEK) - 1;
                if (day < 0)
                    day = 0;


                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                //temp.setDateDisplay(new String(weekDays[day].getBytes("GBK"),"UTF-8")  + "  " + df.format(temp.getMeetingStartDate()));
                temp.setDateDisplay(weekDays[day] + "  " + df.format(temp.getMeetingStartDate()));

                DateFormat df1 = new SimpleDateFormat("HH:mm");
                temp.setStartDisplay(df1.format(temp.getMeetingStartDate()));
                temp.setEndDisplay(df1.format(temp.getMeetingEndDate()));

                meetings.add(temp);
            }   //end for
        } //end while


        //MeetingsDataEntity[] meetings = iGetAllMeetings.GetAllMeetings();

        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");


        String date = "(" + sdf.format(meetings.get(0).getMeetingStartDate()) + "--"
                + sdf.format(meetings.get(meetings.size() - 1).getMeetingStartDate()) + ")";

        if (meetings != null) {
            model.addAttribute("meetings", meetings.toArray());
            model.addAttribute("date", date);
        }
        return "meetings";
    }

}
