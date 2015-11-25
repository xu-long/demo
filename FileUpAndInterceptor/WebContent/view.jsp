<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	姓名：${user.userName }<br>
	头像：<img width="100" height="100" alt="用户头像" src="image/${user.topImage }">image/${user.topImage }
	<br><br>
	<a href="insert">insert</a>
</body>
</html>