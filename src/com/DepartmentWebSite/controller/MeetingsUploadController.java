package com.DepartmentWebSite.controller;


import com.DepartmentWebSite.model.JsonMeetings;
import com.DepartmentWebSite.model.JsonResponse;
import com.DepartmentWebSite.model.MeetingsDataEntity;
import com.DepartmentWebSite.service.IInsertTalbe;
import com.DepartmentWebSite.service.impl.IInsertTableImpl;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

@Controller
@RequestMapping("/meetingUpload")
public class MeetingsUploadController {

    IInsertTalbe mysql=new IInsertTableImpl();

    @RequestMapping()
    public String upload(Model model) {
        return "meetingUpload";
    }

    @RequestMapping(value = "/meetings", method = RequestMethod.POST)
    public String NewsUpload(HttpServletRequest request, Model model, RedirectAttributes attr) throws Exception {

        String person = new String(request.getParameter("person").getBytes("ISO-8859-1"), "UTF-8");
        String passowrd = new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");

        if (meetings.size() > 0) {
            for (int i = 0; i < meetings.size(); i++) {
                MeetingsDataEntity temp = meetings.get(i);

                mysql.InsertTable(temp);
            }
        } else {

        }


        return "redirect:/meetingUpload";
    }

    private HttpServletRequest request;

    private ArrayList<MeetingsDataEntity> meetings = new ArrayList<>();

    private ArrayList<MeetingsDataEntity> getMeetings(FileInputStream fileInputStream) throws IOException {

        ArrayList<MeetingsDataEntity> result = new ArrayList<>();


        POIFSFileSystem pfs = new POIFSFileSystem(fileInputStream);
        HWPFDocument hwpf = new HWPFDocument(pfs);
        Range range = hwpf.getRange();//得到文档的读取范围
        TableIterator it = new TableIterator(range);

        String[] weekDays = {"\u661f\u671f\u65e5", "\u661f\u671f\u4e00", "\u661f\u671f\u4e8c",
                "\u661f\u671f\u4e09", "\u661f\u671f\u56db", "\u661f\u671f\u4e94", "\u661f\u671f\u516d"};

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

                result.add(temp);
            }   //end for
        } //end while

        return result;
    }

    private String excuteFile(MultipartFile file) {

        String result = "";
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (!file.isEmpty()) {
            String file_name = file.getOriginalFilename();
            String suffix = file_name.substring(file_name.lastIndexOf(".") + 1).toLowerCase();

            //File thisFile=new File();
            if (Objects.equals(suffix, "doc")) {
                try {
                    meetings = getMeetings((FileInputStream) file.getInputStream());
                    result = "success";
                } catch (IOException e) {
                    result = "打开word文件失败,检查doc文件";
                }
            } else {
                result = "请上传doc文件";
            }
        }


        return result;
    }

    @RequestMapping(value = "/meetings/file", method = RequestMethod.POST)
    @ResponseBody
    public JsonMeetings fileUpload(MultipartHttpServletRequest request, HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");

        JsonMeetings json = null;

        MultipartFile mf = request.getFile("files");

        if (mf != null) {
            json = new JsonMeetings();
            meetings.clear();
            String result = excuteFile(mf);
            if (Objects.equals(result, "success")) {
                json.setSuccess("success");
                json.setMsg(mf.getOriginalFilename());
                json.setMeetings(meetings);
            } else {
                json.setSuccess("failed");
                json.setMsg(result);
            }
        }
        return json;
    }

}
