package com.DepartmentWebSite.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
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

import com.DepartmentWebSite.model.UploadFile;
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
	
	newsModel news=new newsModel();
	
	adminModel admin=new adminModel();
	
	photoModel photo;
	
	public uploadController() {
		this.iuploadnews=new IUploadNewsImpl();
		this.iinserttable=new IInsertTableImpl();
	}
		
    @RequestMapping()
	public String upload(Model model) {
    	
    	Date now = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
    	
    	String newsID = dateFormat.format(now);
    	
    	if(!model.containsAttribute("news"))
    	{
    		news.setNewsID(newsID);
    		model.addAttribute("news", news);
    	}
    	else
    	{
    		//news.setNewsID("654321");
    		//model.addAttribute("ididid", news);
    	}
    	
    	
    	return "upload";
    
    	
    	
    	
    }
    
    private HttpServletRequest request; 
    
    private boolean saveFile(MultipartFile file) {  
        // 判断文件是否为空  
        
    	request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	
    	if (!file.isEmpty()) {  
            try {  
            	String file_name= file.getOriginalFilename();
            	String file_rename=news.getNewsID().toString() + "_" + file_name;
            	
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "resources\\upload\\"  
                        +   file_rename;
                
                String suffix= file_name.substring(file_name.lastIndexOf(".")+1).toLowerCase();
                
                if(suffix=="bmp"||suffix=="jpeg"||suffix=="jpg"||suffix=="png")
                {
                	//图片文件
                }
                else
                {
                	//其他文件
                }
                	
                
                // 转存文件  
                file.transferTo(new File(filePath));  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
    
    
    @RequestMapping(value= "/uploading",method=RequestMethod.POST)  
    public String NewsUpload(HttpServletRequest request,Model model,RedirectAttributes attr) throws Exception {  
          
    	news.setTitle(new String(request.getParameter("news_title").getBytes("ISO-8859-1"),"UTF-8"));
    	news.setSection(new String(request.getParameter("section").getBytes("ISO-8859-1"),"UTF-8"));
    	news.setReleasePerson(new String(request.getParameter("person").getBytes("ISO-8859-1"),"UTF-8"));
    	news.setText(new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8"));
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
    	Date strD = dateFormat.parse(news.getNewsID());
    	news.setReleaseDate(strD);
    	
    	admin.setName(new String(request.getParameter("person").getBytes("ISO-8859-1"),"UTF-8"));
    	admin.setPassword(new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8"));
    	
    	boolean insertNews=this.iinserttable.InsertTable(news);
    	
    	//model.addAttribute("news", news);
    	attr.addFlashAttribute("news", news);
    	
    	return "redirect:/upload"; 
    }
    
    @RequestMapping(value= "/uploading/file",method=RequestMethod.POST)
    public @ResponseBody UploadFile insertGoodsBrand(MultipartHttpServletRequest request,HttpServletResponse res)
    {
    	res.addHeader("Access-Control-Allow-Origin", "*");
    	
    	UploadFile file=new UploadFile();
 	
    	MultipartFile mf=request.getFile("files");
    	
    	if(mf!=null)
    	{
    		if(saveFile(mf))
    		{
    			file.setSuccess("success");
    			file.setMsg(mf.getOriginalFilename());
    		}
    		else
    		{
    			file.setSuccess("failed");
    			file.setMsg("failed");
    		}
    	}
    	return file;
    }
    
    
    
    @RequestMapping(value= "/uploading/file1",method=RequestMethod.POST)  
    public String fileUpload(@RequestParam("files") MultipartFile[] files,Model model,RedirectAttributes attr) {  
        //判断file数组不能为空并且长度大于0  
    	MultipartFile temp=null;
    	
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i]; 
                temp=file;
               
                //保存文件  
                //saveFile(file);  
            }  
        }  
        // 重定向  
       // enctype="multipart/form-data"
        //request.setAttribute("ma", "222");
        
        if(temp!=null)
        	attr.addFlashAttribute("max",temp.getOriginalFilename());
        
        news.setNewsID(temp.getOriginalFilename());
        
        attr.addFlashAttribute("ididid",news);
        
        //return upload(model);
        return "redirect:/upload";  
    }
    
    
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
