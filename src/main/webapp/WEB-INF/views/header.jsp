<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="page_header">
		<div id="page_heading">
			<a href="./">
				<h1>
					<span>jStore</span>
				</h1>
				
			</a>
		</div>
		<div id="page_headerlinks">
			<ul>
				<%
					if ( (!request.isUserInRole("ROLE_ADMIN")) && (!request.isUserInRole("ROLE_MANAGER")) && (!request.isUserInRole("ROLE_LOGUSER")) ) {
				%>
				<li><a href="login.do">Вход</a></li>
				<%} %>
				<%
					if ( (request.isUserInRole("ROLE_ADMIN")) || (request.isUserInRole("ROLE_MANAGER")) || (request.isUserInRole("ROLE_LOGUSER")) ) {
				%>
				<li><a href="<c:url value="j_spring_security_logout" />">Выход</a></li>
				<%
					}
				%>				
				<li><a href="./shopcartinfo">Корзина</a></li>
				<li class="last"><a href="./contacts">Обратная связь</a></li>
			</ul>
		</div>
		<div id="page_headersearch">
			<h3>Поиск:</h3>
			<form action="Search" method="post">					
				<div>
					<input type="text" name="nameProduct" /> <input type="image"
						src="resources/images/button_go.gif" class="button" />
					<div class="clearthis">&nbsp;</div>
				</div>
				<div class="clearthis">&nbsp;</div>
			</form>
		</div>
		<!-- Start of Page Menu -->
		<div id="page_menu">
			<ul>
				<li><a href="./">Главная</a></li>
				<li><a href="./Status">Статус заказа</a></li>
				<li><a href="./shopcartinfo">Корзина</a></li>
				<%
					if ( request.isUserInRole("ROLE_ADMIN")) {
				%>
				<li><a href="./editproduct">Продукты</a></li>
			
				<li class="last"><a href="./infouser1">Пользователи</a></li>
				<%
					}
				%>
				<%
					if ( request.isUserInRole("ROLE_MANAGER")) {
				%>
				<li><a href="./manager">Менеджер</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<!-- End of Page Menu -->
	</div>
</body>
</html>