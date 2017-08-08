package com.DepartmentWebSite.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.DepartmentWebSite.model.JsonResponse;
import com.DepartmentWebSite.model.accessoryModel;
import com.DepartmentWebSite.model.adminModel;
import com.DepartmentWebSite.model.newsModel;
import com.DepartmentWebSite.model.photoModel;
import com.DepartmentWebSite.service.IUploadNews;
import com.DepartmentWebSite.service.impl.IUploadNewsImpl;
import com.DepartmentWebSite.service.IInsertTalbe;
import com.DepartmentWebSite.service.impl.IInsertTableImpl;


@Controller
@RequestMapping("/upload")
public class uploadController {

    IUploadNews iuploadnews;
    IInsertTalbe iinserttable;

    newsModel news = new newsModel();

    adminModel admin = new adminModel();

    photoModel photo;
    accessoryModel accessory;

    public uploadController() {
        this.iuploadnews = new IUploadNewsImpl();
        this.iinserttable = new IInsertTableImpl();
    }

    @RequestMapping()
    public String upload(Model model) {

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        String newsID = dateFormat.format(now);

        if (!model.containsAttribute("news")) {
            news.setNewsID(newsID);
            model.addAttribute("news", news);
        } else {
            //news.setNewsID("654321");
            //model.addAttribute("ididid", news);
        }


        return "upload";


    }
    private HttpServletRequest request;

    private boolean saveFile(MultipartFile file) {


        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (!file.isEmpty()) {
            try {
                String file_name = file.getOriginalFilename();
                String file_rename = news.getNewsID() + "_" + file_name;



                String filePath = request.getSession().getServletContext().getRealPath("/") + "resources\\upload\\"
                        + file_rename;

                File newFile = new File(filePath);
                Random r = new Random();

                while (newFile.exists()) {
                    file_rename = news.getNewsID() + "_" + Integer.toString(r.nextInt(100)) + "_" + file_name;
                    filePath = request.getSession().getServletContext().getRealPath("/") + "resources\\upload\\"
                            + file_rename;

                    newFile = new File(filePath);
                }

                String suffix = file_name.substring(file_name.lastIndexOf(".") + 1).toLowerCase();

                //图片文件
                if (Objects.equals(suffix, "bmp") || Objects.equals(suffix, "jpeg")
                        || Objects.equals(suffix, "jpg") || Objects.equals(suffix, "png")) {

                    photo = new photoModel();

                    photo.setNewsID(news.getNewsID());
                    photo.setPhotoName(file_rename);

                    if (this.iinserttable.InsertTable(photo)) {
                        file.transferTo(new File(filePath));
                        return true;
                    }
                } else {

                    accessory = new accessoryModel();

                    accessory.setNewsID(news.getNewsID());
                    accessory.setAccessoryName(file_rename);

                    if (this.iinserttable.InsertTalbe(accessory)) {
                        file.transferTo(new File(filePath));
                        return true;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @RequestMapping(value = "/uploading", method = RequestMethod.POST)
    public String NewsUpload(HttpServletRequest request, Model model, RedirectAttributes attr) throws Exception {

        news.setNewsID(new String(request.getParameter("news_id").getBytes("ISO-8859-1"), "UTF-8"));
        news.setTitle(new String(request.getParameter("news_title").getBytes("ISO-8859-1"), "UTF-8"));
        news.setSection(new String(request.getParameter("section").getBytes("ISO-8859-1"), "UTF-8"));
        news.setReleasePerson(new String(request.getParameter("person").getBytes("ISO-8859-1"), "UTF-8"));
        news.setText(new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date strD = dateFormat.parse(news.getNewsID());
        news.setReleaseDate(strD);

        admin.setName(new String(request.getParameter("person").getBytes("ISO-8859-1"), "UTF-8"));
        admin.setPassword(new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8"));

        boolean insertNews = this.iinserttable.InsertTable(news);

        //model.addAttribute("news", news);
        attr.addFlashAttribute("news", news);

        return "redirect:/upload";
    }

    @RequestMapping(value = "/uploading/file", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse fileUpload(MultipartHttpServletRequest request, HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");

        JsonResponse file = new JsonResponse();

        MultipartFile mf = request.getFile("files");

        if (mf != null) {
            //if (saveFile(mf)) {
            if (true) {
                file.setSuccess("success");
                file.setMsg(mf.getOriginalFilename());
            } else {
                file.setSuccess("failed");
                file.setMsg("failed");
            }
        }
        return file;
    }


     /*
    @RequestMapping(value = "/uploading/file1", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("files") MultipartFile[] files, Model model, RedirectAttributes attr) {
        //�ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0  
        MultipartFile temp = null;

        if (files != null && files.length > 0) {
            //ѭ����ȡfile�����е��ļ�  
            for (MultipartFile file : files) {
                temp = file;

                //�����ļ�  
                //saveFile(file);  
            }
        }

        if (temp != null)
            attr.addFlashAttribute("max", temp.getOriginalFilename());

        news.setNewsID(temp != null ? temp.getOriginalFilename() : null);

        attr.addFlashAttribute("ididid", news);

        //return upload(model);
        return "redirect:/upload";
    }*/
    
    
    /*
    @RequestMapping(value= "/uploading",method=RequestMethod.POST)
	public String index(Model model) {
    	
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                        
    	
    	String sss= request.getParameter("file1");
    	InputStream s;
    	try {
			s= request.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return "upload";
    
    }
    
    @RequestMapping(value= "/uploading1",method=RequestMethod.POST)
	public @ResponseBody Juansb index2(@RequestParam("file1") MultipartFile file1) {
    	
    	Juansb s=new Juansb();
    	s.setMsg(file1.getOriginalFilename());
    	s.setSuccess(true);
    	
    	
    	
    	
    	
    	
    	
    	
    	return s;
    
    }
    
    
    
    
    
    @RequestMapping(value= "/uploading",method=RequestMethod.GET)
	public String index2(Model model) {
    	
    	HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
    	
    	String sss= request.getParameter("test");
    	
    	model.addAttribute("ma", "222");
    	
    	return "upload";
    
    }*/
}
