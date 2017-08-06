<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<title>第一事业部部门主页</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.3.2.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#featured > ul").tabs({fx:{opacity: "toggle"}}).tabs("rotate", 5000, true);
});
</script>
<!-- Cufon START  -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/cufon-yui.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/GeosansLight_500.font.js" type="text/javascript"></script>
 
  
<!-- Cufon END  -->
</head>
<body>
<div id="main_container">


    
	    <div class="header">
            <div class="logo">第一事业部</div>
            <div class="slogan"> | 打造一流品牌</div> 
        </div> <!--end of header--> 
    
    <div class="menu">
        <ul>
        <li><a href="<%=request.getContextPath()%>/index">主页</a></li>   
        
        <li><a>应知应会</a>        
            <ul>
            	<li><a href="<%=request.getContextPath()%>/more/standard" title="">标准规范</a></li>
            	<li><a href="<%=request.getContextPath()%>/more/rules" title="">规章制度</a></li>
            	<li><a href="<%=request.getContextPath()%>/more/knowledge" title="">知识库相关</a></li>
            </ul>        
        </li> 
               
        <li><a>友情链接</a>
            <ul>
            <li><a href="www.804.sast.casc/main.asp" title="">电子所主页</a></li>
            <li><a href="www.804.sast.casc/main/index.asp" title="">保密处</a></li>
            <li><a href="10.123.0.25/caiwu" title="">财务处</a></li>
            <li><a href="10.123.0.21:8089/index.html" title="">质量保障部</a></li>           
            </ul>
        </li>
        <li><a href="ftp://10.123.0.17/">一周会议安排</a></li>
        <li><a href="">文件下载</a></li>
        <li><a href="<%=request.getContextPath()%>/about">关于我们</a></li>
        </ul>
    </div>
         
         
<div id="slider1" class="sliderwrapper">
	<div class="slider_content">
		<div id="featured">
        <div id="fragment-1" class="ui-tabs-panel" style="">
            <img src="<%=request.getContextPath()%>/resources/images/${roll1.photoID}" alt="" title="" border="0" />
            
        </div>
        
        <div id="fragment-2" class="ui-tabs-panel" style="">
            <img src="<%=request.getContextPath()%>/resources/images/${roll2.photoID}" alt="" title="" border="0" />
            
        </div>
        
        <div id="fragment-3" class="ui-tabs-panel" style="">
            <img src="<%=request.getContextPath()%>/resources/images/${roll3.photoID}" alt="" title="" border="0" />
            
        </div>
        
        <div id="fragment-4" class="ui-tabs-panel" style="">
            <img src="<%=request.getContextPath()%>/resources/images/${roll4.photoID}" alt="" title="" border="0" />
            
        </div>
        
        <div id="fragment-5" class="ui-tabs-panel" style="">
            <img src="<%=request.getContextPath()%>/resources/images/${roll5.photoID}" alt="" title="" border="0" />
            
        </div>
        
		  <ul class="ui-tabs-nav">                    
	        <li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-1"><a href="#fragment-1">${roll1.title}</a></li>
            <li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-2"><a href="#fragment-2">${roll2.title}</a></li>
            <li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-3"><a href="#fragment-3">${roll3.title}</a></li>
            <li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-4"><a href="#fragment-4">${roll4.title}</a></li>
            <li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-5"><a href="#fragment-5">${roll5.title}</a></li>
	      </ul>
  
	   </div>

	</div>

</div>  <!--end of slider --> 

		<div class="center_content">
        	<div class="leftbox">
              <h2>重要通知</h2>
              <img src="<%=request.getContextPath()%>/resources/images/pic1.jpg" alt="" title="" border="0" /><br>
              
              <a href="<%=request.getContextPath()%>/news/${zytz1.newsID}" class="juan">${zytz1.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zytz2.newsID}" class="juan">${zytz2.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zytz3.newsID}" class="juan">${zytz3.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zytz4.newsID}" class="juan">${zytz4.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zytz5.newsID}" class="juan">${zytz5.title}</a><br>
              
              <a href="<%=request.getContextPath()%>/more/notification" class="more">更多</a>
        	</div>
            
        	<div class="leftbox">
              <h2>质量动态</h2>
              <img src="<%=request.getContextPath()%>/resources/images/pic2.jpg" alt="" title="" border="0" /><br>
              <a href="<%=request.getContextPath()%>/news/${zlxx1.newsID}" class="juan">${zlxx1.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zlxx2.newsID}" class="juan">${zlxx2.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zlxx3.newsID}" class="juan">${zlxx3.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zlxx4.newsID}" class="juan">${zlxx4.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${zlxx5.newsID}" class="juan">${zlxx5.title}</a><br>
              <a href="<%=request.getContextPath()%>/more/quality" class="more">更多</a>
        	</div>
            
        	<div class="leftbox_right">
              <h2>部门文化</h2>
              <img src="<%=request.getContextPath()%>/resources/images/pic3.jpg" alt="" title="" border="0" /><br>
              <a href="<%=request.getContextPath()%>/news/${bmdt1.newsID}" class="juan">${bmdt1.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bmdt2.newsID}" class="juan">${bmdt2.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bmdt3.newsID}" class="juan">${bmdt3.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bmdt4.newsID}" class="juan">${bmdt4.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bmdt5.newsID}" class="juan">${bmdt5.title}</a><br>
              <a href="<%=request.getContextPath()%>/more/culture" class="more">更多</a>
        	</div>

        </div>
         
         
		<div class="center_content">
        
        	<div class="leftbox">
              <h2>荣誉榜</h2>
			  <a href="<%=request.getContextPath()%>/news/${ryb1.newsID}" class="juan">${ryb1.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${ryb2.newsID}" class="juan">${ryb2.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${ryb3.newsID}" class="juan">${ryb3.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${ryb4.newsID}" class="juan">${ryb4.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${ryb5.newsID}" class="juan">${ryb5.title}</a><br>
              <a href="<%=request.getContextPath()%>/more/honor" class="more">更多</a> 
                      
        	</div>
        
        
        
        	<div class="leftbox">
              <h2>外场纪实</h2>
              <a href="<%=request.getContextPath()%>/news/${bcjs1.newsID}" class="juan">${bcjs1.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bcjs2.newsID}" class="juan">${bcjs2.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bcjs3.newsID}" class="juan">${bcjs3.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bcjs4.newsID}" class="juan">${bcjs4.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${bcjs5.newsID}" class="juan">${bcjs5.title}</a><br>
              <a href="<%=request.getContextPath()%>/more/report" class="more">更多</a> 
        	</div>
            

            
        	<div class="leftbox_right">
              
              
              <h2>产品简介</h2>
              <a href="<%=request.getContextPath()%>/news/${qyzx1.newsID}" class="juan">${qyzx1.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${qyzx2.newsID}" class="juan">${qyzx2.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${qyzx3.newsID}" class="juan">${qyzx3.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${qyzx4.newsID}" class="juan">${qyzx4.title}</a><br>
              <a href="<%=request.getContextPath()%>/news/${qyzx5.newsID}" class="juan">${qyzx5.title}</a><br>
              <a href="<%=request.getContextPath()%>/more/product" class="more">更多</a> 
              
        	</div> 

        </div>  
         
        
        <div class="clear"></div>
        
        
        
<div class="footer">
    <div class="copyrights">
    @2017 第一事业部测发控系统室出品
    </div>
    <div class="footer_right">
    <a href="<%=request.getContextPath()%>/index">主页</a>
    <a href="<%=request.getContextPath()%>/about">关于我们</a>
    <a href="#">一周安排</a>
    <a href="<%=request.getContextPath()%>/upload">管理员</a>
    </div>
    <div class="clear"></div>
</div>

</div> <!--end of main container-->

</body>
</html>