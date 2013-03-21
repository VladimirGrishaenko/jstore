<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
</html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value="resources/scripts/ControlProduct.js" />"></script>	
	<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery-1.9.1.js" />"></script>
<title>Shop</title>
</head>
<div id="container">
	<!-- Start of Page Header -->
	<c:import url="/WEB-INF/views/header.jsp" />
	<!-- End of Page Header -->

	<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Список товаров</h2>
			</div>
			<ul>
				<c:forEach var="type" items="${types}">			
						<li><h5><a href="dddd?pType=${type.productType}">${type.productType}</a></h5></li>	
				</c:forEach>
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
		<!-- End of Categories Box -->

	</div>
	<!-- Start of Main Content Area -->
	<div id="main_content">
	 <br><br><h1>JStore</h1> <br> <br>
	
	
	<h2>Контакты: </h2><br>
	<h2>Телефон: (042)333-333</h2><br>
	<h2>Телефон: (0562)444-444</h2><br><br>
	<h2>E-mail: jstore@gmail.com</h2><br><br>
	
	<h2>Адрес: г.Днепропетровск,</h2>
		<h2> ул.Барикадная 1</h2><br>	
	
	
	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>