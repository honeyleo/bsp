<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>授权使用玩立方账号</title>
</head>
<body>
<div>
	<form action="login" method="post">
		用户名:<input type="text" name="username"/>
		<br>密码:<input type="password" name="password"/>
		<input type="hidden" name="client_id"  value="${client_id}">
		<input type="hidden" name="redirect_uri"  value="${redirect_uri}">
		<input type="hidden" name="response_type"  value="${response_type}">
		<br><input type="submit" value="授权并登录"/>
	</form>
</div>
</body>
</html>