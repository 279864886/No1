<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function juan1() {
			$.get("/SpringHello/hello/1", function(data) {
				alert(data);
			});
		};
		function juan2() {
			$.get("/SpringHello/hello/2", function(data) {
				alert(data);
			});
		}
	</script>
	<a href="#" onclick="juan1()">娟1</a>
	<a href="#" onclick="juan2()">娟2</a>

</body>
</html>