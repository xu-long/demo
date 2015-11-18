<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="studentAction?flag=save" method="post">
		姓名:<input name="name"><br>
		性别:<input name="sex"><br>
		年龄:<input name="age"><br>
		<input type="submit" value="添加">
	</form> -->
	
	<form action="test" method="post">
		姓名:<input name="stu.sname"><br>
		性别:<input name="stu.ssex"><br>
		年龄:<input name="stu.sage"><br>
		<input type="submit" value="测试注解">
	</form>
	<a href="studentAction?flag=query">查看所有学生</a>
	
</body>
</html>