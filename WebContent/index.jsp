<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大佬鼠音乐播放器</title>
</head>
<body>
	<jsp:forward page="/servlet/FileInputServlet">
		<jsp:param value="music" name="op"/>
	</jsp:forward>
</body>
</html>