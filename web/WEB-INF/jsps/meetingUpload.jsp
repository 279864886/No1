<%--
  Created by IntelliJ IDEA.
  User: chenwenhao
  Date: 2017/8/11
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>第一事业部部门主页</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/dataTables.bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.css"/>


    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/dataTables.bootstrap.js"></script>


    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/cufon-yui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/GeosansLight_500.font.js" type="text/javascript"></script>


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
            <li><a href="<%=request.getContextPath()%>/meetings">一周会议安排</a></li>
            <li><a href="ftp://10.123.0.17/">文件下载</a></li>
            <li><a href="<%=request.getContextPath()%>/about">关于我们</a></li>
        </ul>
    </div>

    <div class="center_content_pages">
        <h2 style="text-align: center">运载领域一周会议安排上传</h2>


        <form id="file_upload_id" action="<%=request.getContextPath()%>/upload/uploading/file" method="post"
              enctype="multipart/form-data">
            <div class="form_row">
                <a id="add_file" onclick="type_file()" href="javascript:void(0)">一周安排文件</a>
                <input type="file" class="form_file1" id="files" name="files"
                       onchange="FileUpload_onselect(this)"/>
            </div>
        </form>


    </div>

    <div class="footer">
        <div class="copyrights">
            @2017 第一事业部测发控系统室出品
        </div>
        <div class="footer_right">
            <a href="<%=request.getContextPath()%>/index">主页</a>
            <a href="<%=request.getContextPath()%>/about">关于我们</a>
        </div>
        <div class="clear"></div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#example').dataTable({
            "bPaginate": false, //翻页功能
            "bLengthChange": false, //改变每页显示数据数量
            "bFilter": true, //过滤功能
            "bSort": false, //排序功能
            "bInfo": false,//页脚信息
            "bAutoWidth": true//自动宽度
        });
    });

    function type_file() {
        $(":file").trigger("click");
    }

    function FileUpload_onselect(node) {

        var URL = "http://" + location.host + "/No1/meetingUpload/file";
        var files = $("#files").prop("files");
        var data = new FormData();
        data.append("files", files[0]);

        $.ajax({
            url: URL,
            type: "post",
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                $("#file_upload_id").append("<div class=\"form_row\"><p>" + data.msg + "</p></div>");
                var temp = data.success;

                if (temp === "success")
                    alert("文件上传成功！");
                else if (temp === "failed")
                    alert("文件上传失败，联系管理员！");
            }
        });
    }

</script>


</body>
</html>
