<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop</title>
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/header.jsp" />

	<div id="main_content">
	<div id="login">
	<h2>Вход в систему</h2><br/>
	<form action="j_spring_security_check" method="post">
		<label for="j_username">Логин</label>: 
		<input id="j_username"	name="j_username" size="20" maxlength="50" type="text" /> <br /> <br/>
		<label for="j_password">Пароль</label>: 
		<input id="j_password"	name="j_password" size="20" maxlength="50" type="password" /> <br /><br/>
		<button id=batton_login type="submit" value="Login">Войти</button>
	</form>
	<br/>
	<a href="./">Back to main</a>
	</div>
	</div>
	<c:import url="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>