<%--
  Created by IntelliJ IDEA.
  User: chenwenhao
  Date: 2017/8/16
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>


    <title>关于我们</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>

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
                    <li><a href="http://www.804.sast.casc/main.asp" title="">电子所主页</a></li>
                    <li><a href="http://www.804.sast.casc/main/index.asp" title="">保密处</a></li>
                    <li><a href="http://10.123.0.25/caiwu" title="">财务处</a></li>
                    <li><a href="http://10.123.0.21:8089/index.html" title="">质量保障部</a></li>
                </ul>
            </li>
            <li><a href="<%=request.getContextPath()%>/meetings">一周会议安排</a></li>
            <li><a href="ftp://10.123.0.17/">文件下载</a></li>
            <li><a href="<%=request.getContextPath()%>/about">关于我们</a></li>
        </ul>
    </div>


    <div class="center_content_pages">


        <div class="morenews">
            <h2>第一事业部简介</h2>
        </div>


        <div class="clear"></div>
    </div>


    <div class="footer">
        <div class="copyrights">
            @2017 第一事业部测发控系统室出品（建议使用Firefox或Chrome浏览器，你懂的）
        </div>
        <div class="footer_right">
            <a href="<%=request.getContextPath()%>/index">主页</a>
            <a href="<%=request.getContextPath()%>/about">关于我们</a>
            <a href="<%=request.getContextPath()%>/meetings">一周安排</a>
        </div>
        <div class="clear"></div>
    </div>

</div>
</body>
</html>
