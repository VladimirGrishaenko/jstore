<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/tramps.css" />"
	rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery-1.9.1.js" />"></script>
<script type="text/javascript"	
	src="<c:url value="resources/scripts/manager.js" />"></script>
<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery.tablesorter.js" />"></script>
<title>Shop</title>
</head>
<body>
<div id="container">
<c:import url="/WEB-INF/views/header.jsp" />
<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
	<div id="categories">
			<div id="categories_header">
				<h2>Список товаров</h2>
			</div>
			<ul>
		
			
				<c:forEach var="type" items="${productTypes}">			
						<li><h5><a href="./?lt=${type.getId()}&${link}">${type.productType}</a></h5></li>	
							</c:forEach>
						<li class="last"><h5><a href="./?lt=0&${link}">Весь список</a></h5></li>	
		
						
						
						
			
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
	
	
	
		<!-- End of Categories Box -->
</div>
	
	<!-- End of Left Sidebar -->
<div id="main_content">
<br>
<br>
<form method="get">
Поиск статуса заказа по номеру: <input type="text" id="id" name="id"> 
<input type="submit">	
</form>
<br>
<br>
<br>

${order}
</div>
<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>