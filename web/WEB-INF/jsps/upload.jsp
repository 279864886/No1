<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>


    <title>部门新闻上传</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/style.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
    <script type="text/javascript">

        $(function () {
            var temp = $("#juan").val();

            if (temp == "222")
                alert("222");
        })

        function type_file() {

            //$("#file_upload_id").append("<div class=\"form_row\"><p>${max}</p></div>");
            $(":file").trigger("click");
        }

        function add() {
            $("#news").append("<div class=\"form_row\"><label>附带文件:</label><input type=\"file\" class=\"form_file\" name=\"files\"/><button onclick=\"minus(this);return false;\">删除</button>	<br/></div>");
            return false;
        }

        function minus(row) {
            $(row).parent().remove();
        }

        function FileUpload_onselect(node) {

            var URL = "http://" + location.host + "/No1/upload/uploading/file";
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
                    var temp=data.success;

                    if(temp==="success")
                        alert("文件上传成功！");
                    else if(temp==="failed")
                        alert("文件上传失败，联系管理员！");
                }
            });
        }

        function onselected() {

            var temp = $("#selected").val();

            if (temp == "no") {
                var juan = $("#toutiaotupian").length;

                if (juan == 1) {
                    $("#toutiaotupian").remove();
                }
            }
            else {
                var juan = $("#toutiaotupian").length;

                if (juan == 0) {

                    $("#shangtoutiao").append("<div id=\"toutiaotupian\" class=\"form_row\"><label>头条图片:</label><input type=\"file\" class=\"form_file2\" id=\"fujian\" name=\"fujian\" /></div>");
                }
            }

            return false;
        }

        function news_upload_submit() {
            if ($("#news_title").val() == "") {
                alert("上传新闻的标题不能为空！！！");
            }
            else if ($("#person").val() == "" || $("#password").val() == "") {
                alert("发布人的姓名或密码不能为空！！！");
            }
            else {
                $("#news").submit();
            }

        }
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

            <h2>部门新闻上传</h2>

            <div class="form">

                <form id="news" action="<%=request.getContextPath()%>/upload/uploading" method="post">
                    <div class="form_row">
                        <label>新闻编号:</label>
                        <input type="text" class="form_input" id="news_id" name="news_id" readonly="readonly"
                               value=${news.newsID}></input>
                    </div>


                    <div class="form_row">
                        <label>新闻标题:</label>
                        <input type="text" class="form_input" id="news_title" name="news_title"/>
                    </div>

                    <div class="form_row">
                        <label>所属版块:</label>
                        <select id="section" name="section" align="left">
                            <option value="notification">重要通知</option>
                            <option value="quality">质量动态</option>
                            <option value="culture">部门文化</option>
                            <option value="honor">荣誉榜</option>
                            <option value="report">外场纪实</option>
                            <option value="product">产品简介</option>
                            <option value="standard">标准规范</option>
                            <option value="rules">规章制度</option>
                            <option value="knowledge">知识库相关</option>
                        </select>
                    </div>

                    <!--
                    <div id="shangtoutiao" class="form_row">
                        <label>是否上头条:</label>
                        <select id="selected" name="selected" align="left" onchange="onselected();return false;">
                            <option value="no">否</option>
                            <option value="yes">是</option>
                        </select>
                    </div> -->

                    <div class="form_row">
                        <label>上传人:</label>
                        <input type="text" class="form_input" id="person" name="person"/>
                    </div>

                    <div class="form_row">
                        <label>密码:</label>
                        <input type="password" class="form_input" id="password" name="password"/>
                    </div>


                    <div class="form_row">
                        <label>新闻内容:</label>
                        <textarea class="form_textarea" id="content" name="content"></textarea>
                    </div>


                    <input type="button" class="form_submit" value="上传" onclick="news_upload_submit()"/>
                </form>


                <form id="file_upload_id" action="<%=request.getContextPath()%>/upload/uploading/file" method="post"
                      enctype="multipart/form-data">
                    <div class="form_row">
                        <a id="add_file" onclick="type_file()" href="javascript:void(0)">附带文件</a>
                        <input type="file" class="form_file1" id="files" name="files"
                               onchange="FileUpload_onselect(this)"/>
                    </div>
                </form>


                <!--
                        <form id="file_upload_id" action="<%=request.getContextPath()%>/upload/uploading/file" method="post" enctype="multipart/form-data">
                       		<div class="form_row">
                        		<label>附带文件:</label>
                        		<input type="file" class="form_file" name="files" onchange="return FileUpload_onselect(this)"/>
                        		<button onclick="add()">添加</button><br/>
                        	</div>
                       </form>-->
            </div>

        </div>


        <div>
            <p>${news.text}</p>
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
        </div>
        <div class="clear"></div>
    </div>

</div> <!--end of main container-->


</body>
</html>