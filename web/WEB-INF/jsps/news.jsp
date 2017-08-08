<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>


    <title>${currentnews.title}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#featured > ul").tabs({fx: {opacity: "toggle"}}).tabs("rotate", 5000, true);
        });
    </script>
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
                    <li><a href="" title="">设计标准</a></li>
                    <li><a href="" title="">三层次文件</a></li>
                    <li><a href="<%=request.getContextPath()%>/more/zsk" title="">知识库相关</a></li>
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
            <li><a href="<%=request.getContextPath()%>/meetings">一周会议安排</a></li>
            <li><a href="ftp://10.123.0.17/">文件下载</a></li>
            <li><a href="<%=request.getContextPath()%>/about">关于我们</a></li>
        </ul>
    </div>


    <div class="center_content_pages">


        <div class="morenews">
            <h2>${currentnews.title}</h2>

            <c:if test="${not empty currentphoto}">
                <img src="<%=request.getContextPath()%>/resources/images/${currentphoto.photoName}" alt="" title=""
                     border="0" class="pages_pic"/>
            </c:if>

            <p>${currentnews.text}</p>


            <!--a href="<%=request.getContextPath()%>/resources/doc/1.docx">11111</a>  -->

        </div>


        <div class="clear"></div>
    </div>


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